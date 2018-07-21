package com.lee.section02;

import java.nio.file.attribute.FileTime;

public class FileAttributes {
    public FileTime ModifiedTime;
    public Long FileSize;

    public FileAttributes(FileTime modifiedTime, Long fileSize) {
        ModifiedTime = modifiedTime;
        FileSize = fileSize;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof FileAttributes)) {
            return false;
        }

        FileAttributes fa = (FileAttributes)o;

        return fa.ModifiedTime == this.ModifiedTime
                && fa.FileSize == this.FileSize;
    }

    //Idea from effective Java : Item 9
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + ModifiedTime.hashCode();
        result = 31 * result + FileSize.hashCode();
        return result;
    }

}
