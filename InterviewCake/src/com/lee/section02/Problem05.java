package com.lee.section02;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;

public class Problem05 {

    // 1. Modified time
    // 2. File size
    // 3. CRC32

    List<FilePaths> FindDuplicateFiles(List<Path> files) throws Exception {
        List<FilePaths> duplicatePaths = new ArrayList<FilePaths>();

        HashMap<FileAttributes, Path> fileAttributesHashes = new HashMap();
        HashMap<Long, Path> fileHashes = new HashMap<>();


        for (Path path : files) {
            Long hash = GetHashOfFile(path);

            if (fileHashes.containsKey(hash)) {
                Path path1 = path;
                Path path2 = fileHashes.get(hash);

                BasicFileAttributes attr1 = Files.readAttributes(path1, BasicFileAttributes.class);
                BasicFileAttributes attr2 = Files.readAttributes(path2, BasicFileAttributes.class);

                Path dupPath, origPath;
                if (attr1.creationTime().compareTo(attr2.creationTime()) < 0 ) {
                    origPath = path1;
                    dupPath = path2;
                }
                else {
                    origPath = path2;
                    dupPath = path1;
                }
                FilePaths fp = new FilePaths(dupPath, origPath);
                duplicatePaths.add(fp);
                continue;
            }

            fileHashes.put(hash, path);
        }

        return duplicatePaths;
    }

    Long GetHashOfFile(Path path) throws Exception {
        Long chksum = null;
        FileInputStream fis = new FileInputStream(path.toFile());
        Checksum chk = new CRC32();
        CheckedInputStream cis = new CheckedInputStream(fis, chk);
        byte[] buff = new byte[80];
        while (cis.read(buff) >= 0) ;
        chksum = chk.getValue();
        return chksum;
    }
}

