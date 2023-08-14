package cn.wedding.util;

import io.minio.*;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
public class MinioUtils {
    @Autowired
    private static MinioClient client;

    public static void add(String bucketName){
        try {
            if(!exist(bucketName)){
                client.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }
        } catch (Exception e) {
            throw new RuntimeException("Bucket添加异常！");
        }
    }

    public static void delete(String bucketName){
        try {
            if(!exist(bucketName)){
                client.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
            }
        } catch (Exception e) {
            throw new RuntimeException("Bucket删除异常！");
        }
    }


    public static boolean exist(String bucketName){
        try {
            return client.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
