package com.test;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobItem;
import com.azure.storage.common.StorageSharedKeyCredential;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.io.File;
import java.io.FileWriter;
import java.util.Locale;

/**
 * @author sunil
 * @project AzureApp
 * @created 2021/06/08 4:25 PM
 */
public class ConnectionCheck {
    public static void main(String[] args) throws Exception{


        //client
        String account_name= "account_name";
        String toxp = "toxpt";
        String from_xp = "fromxmp";



        System.out.println("Hi");

        System.out.println("Azure Blob Storage v12 - Java quickstart sample\n");

        String connectStr = "connectStr";

        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectStr).buildClient();
        String containerName = toxp;
        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);

        System.out.println(containerClient.getBlobContainerName());

        //reading
        String fileName = "status.json";
        BlobClient blobClient = containerClient.getBlobClient(fileName);

        System.out.println("\nDownloading blob to\n\t " + fileName);

        blobClient.downloadToFile( fileName);



        //writing
        String outcontainerName = from_xp;
        BlobContainerClient outcontainerClient = blobServiceClient.getBlobContainerClient(outcontainerName);

        String outputFIle = "output_status.json";
        BlobClient outputblobClient = outcontainerClient.getBlobClient(outputFIle);

        FileWriter writer = new FileWriter(outputFIle, true);
        writer.write("Hello, World! for testing purpose");
        writer.close();
//
        outputblobClient.uploadFromFile( outputFIle);
////





    }
}
