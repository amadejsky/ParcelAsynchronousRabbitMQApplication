# Distributed Parcel Management System

## Description

This is a microservices-based application built using **Spring Cloud**, **Spring**, and **RabbitMQ** for message queuing. The system allows for managing parcels, tracking their status, and administering the application through an admin panel. The application uses **MongoDB** as its database.

## Architecture

1. **Parcel Manager** [localhost:9000/admin-tool/list](http://localhost:9000/admin-tool/list) - Manages parcels and their statuses. Communicates with MongoDB Atlas and RabbitMQ for notification handling.
   ![Parcel Manager Admin Panel](https://github.com/amadejsky/Resources/blob/main/Mockup/parcelManagerAdminPanel.png)

2. **Customer Client** [localhost:8090/manage/app](http://localhost:8090/manage/app) - A user-facing application that allows sending and tracking parcels. Communicates with other microservices using OpenFeign.
   - **Sending a Parcel**
     ![Parcel Manager Send Parcel](https://github.com/amadejsky/Resources/blob/main/Mockup/parcelManagerSendParcel.png)
   - **Tracking a Parcel**
     ![Parcel Manager Track](https://github.com/amadejsky/Resources/blob/main/Mockup/parcelManagerTrack.png)

3. **Notification Receiver** - Receives notifications from RabbitMQ and processes them.

4. **Gateway** - Configured as a Eureka client that routes requests to the appropriate microservices.
   ![Eureka and Spring Cloud](https://github.com/amadejsky/Resources/blob/main/Mockup/parcelManagerEurekaSpringCloud.png)

## Features

- **Service Registration**: All services are registered with the Eureka server, enabling dynamic discovery and routing.
- **Parcel Management**: Add, edit, and delete parcels. Track parcel status.
- **Notifications**: Send notifications about parcel status changes using RabbitMQ.
- **User Interface**: Users can send parcels and track their status through a user-friendly interface.
- **Admin Panel**: Manage parcels and monitor the system from an administrative panel.

## Requirements

- JDK 17 or higher
- MongoDB Atlas
- RabbitMQ
- Eureka Server

## Installation

1. **Clone the repository**

   ```bash
   git clone <REPOSITORY_URL>
   cd <REPOSITORY_NAME>
