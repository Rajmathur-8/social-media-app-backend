# Social Media App

This project is a comprehensive social media platform developed using React, Spring Boot, Spring Security, MySQL, Tailwind CSS, and MUI. The app features key functionalities like post creation, liking, saving, reposting, and commenting, along with advanced features like real-time messaging.

## Features

- **Post Creation, Liking, Saving, Reposting, and Commenting**: Allows users to create posts, like, save, repost, and comment on posts for enhanced engagement.
- **Real-Time Messaging**: Utilizes Spring Security and WebSockets to provide seamless and secure real-time communication.
- **User Profile Management**: Users can update their profiles and manage connections through follow/unfollow actions, ensuring data integrity and security.

## Technologies Used

- **Backend**:
  - Spring Boot
  - Spring Security
  - MySQL

- **Real-Time Communication**:
  - WebSockets

## Installation

### Prerequisites

- Java 11 or higher
- Node.js and npm
- MySQL

### Backend Setup

1. **Clone the repository**:

   ```bash
   git clone https://github.com/your-username/social-media-app.git
   cd social-media-app
   ```

2. **Set up MySQL Database**:

   Create a MySQL database and update the `application.properties` file in the `src/main/resources` directory with your database details.

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. **Build and run the backend**:

   ```bash
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

## Usage

1. **Access the application**:

   Open your browser and navigate to `http://localhost:8080` for the backend.

2. **Create an account**:

   Sign up and create a new account.

3. **Explore features**:

   - Create, like, save, repost, and comment on posts.
   - Update your profile and follow/unfollow other users.
   - Use the real-time messaging feature for instant communication.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgements

- Thanks to the open-source community for providing the tools and libraries used in this project.

## Contact

For any inquiries or issues, please contact Raj Mathur at [rajmathur8409@gmail.com](mailto:rajmathur8409@gmail.com).

---

This README provides an overview of the project, installation steps, usage instructions, and additional information for contributing and contacting.
