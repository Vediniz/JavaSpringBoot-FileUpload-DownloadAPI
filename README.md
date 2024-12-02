<h1 align="center"> Java Spring Boot - File Upload </h1>
<p align="center">
  This project is a Spring Boot application that implements file upload and download functionality.
  It includes endpoints for uploading single and multiple files, as well as for downloading files.
</p>

<br>

<p align="center">
  <a href="#project-notes"><strong>Project Notes</strong></a> •
  <a href="#getting-started"><strong>Getting Started</strong></a> •
  <a href="#using-the-application"><strong>Using the Application</strong></a> •
</p>

<br>

## **Project Notes**
- To run the project:
    - Install all dependencies listed in the `pom.xml` file.
    - The project uses the _/src/main/resources/files_ directory to store  files.

## **Getting Started**
Clone the repository and run it.

~~~bash
# Clone the repository 
$ git clone git@github.com:Vediniz/JavaSpringBoot-FileUpload-DownloadAPI.git
~~~

## **Using the Application**
Use the following `curl` commands to test the application's main endpoints.

### **Upload a File**
This endpoint allows you to upload a single file.

~~~bash
curl -X POST http://localhost:8080/api/file/v1/uploadFile -H "Content-Type: multipart/form-data" -F 'file=@/path/to/your/file.txt'
~~~

### **Upload Multiple Files**
This endpoint allows you to upload multiple files.

~~~bash
curl -X POST http://localhost:8080/api/file/v1/uploadMultipleFile -H "Content-Type: multipart/form-data" -F 'files=@/path/to/your/file1.txt' -F 'files=@/path/to/your/file2.txt'
~~~

### **Download a File**
This endpoint allows you to download a file by its name.

~~~bash
curl -X GET http://localhost:8080/api/file/v1/downloadFile/{filename} -H "Accept: application/octet-stream" --output /path/to/save/your/file.txt
~~~

