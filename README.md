Wireless Data Transfer Application with LDAP Authentication

Introduction
The Wireless Data Transfer Application is designed to securely upload and download images, leveraging Spring Boot and Spring Security with LDAP authentication. The application stores images both in a MySQL database and on the local file system, ensuring flexibility and security.

Features
Image Upload: Upload images to both the database and the file system.

Image Download: Retrieve and serve images upon request.

Secure Authentication: Implemented LDAP authentication for secure access.

Image Compression: Utilized custom utilities for efficient image compression and decompression.

Global Exception Handling: Comprehensive error handling to ensure a smooth user experience.

Technologies Used
Java 17

Spring Boot

Spring Security with LDAP Integration

MySQL

Apache Directory Studio (requires JDK 11)

Maven

Setup Instructions
Clone the Repository:

sh
git clone https://github.com/madhumitha2023/WirelessDataTransferApplication-LdapAuthentication.git
Database Setup:

Ensure MySQL is installed and running.

Create a database named storagedb.

Update the application.yml with your database credentials.

LDAP Setup:

Ensure OpenLDAP is installed and configured.

Use Apache Directory Studio for managing LDAP (requires JDK 11).

Build and Run:

Navigate to the project directory:

sh
cd WirelessDataTransferApplication-LdapAuthentication
Build the project using Maven:

sh
mvn clean install
Run the application:

sh
mvn spring-boot:run

Endpoints
Upload Image: POST /api/v1/image

Upload Image to File System: POST /api/v1/image/fileSystem

Download Image: GET /api/v1/image/{fileName}

Download Image from File System: GET /api/v1/image/fileSystem/{fileName}

Contribution
Feel free to fork this repository and contribute by submitting pull requests. For major changes, please open an issue first to discuss what you would like to change.

Acknowledgements
Special thanks to the tools and technologies that made this project possible, including the ever-reliable Apache Directory Studio which, by the way, works seamlessly with JDK 11!
