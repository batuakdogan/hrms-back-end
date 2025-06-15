
# HRMS - Human Resource Management System API

This is the backend API for a Human Resource Management System (HRMS). It provides a RESTful interface for managing candidates, employers, staff, job advertisements, and candidate CVs. The system includes features like user registration, email verification, job posting with an approval workflow, and detailed CV management.

##  Built With

<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" height="30"/>
<img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" height="30"/>
<img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" height="30"/>
<img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" height="30"/>
<img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black" height="30"/>
<img src="https://img.shields.io/badge/Cloudinary-3448C5?style=for-the-badge&logo=cloudinary&logoColor=white" height="30"/>

##  Features

*   **Role-Based Access Control:** Differentiates between Candidates, Employers, and System Staff.
*   **User Authentication:** Secure registration and login for all user types.
*   **Email Verification:** New users must verify their email address to activate their account.
*   **Job Advertisement Management:** Employers can create, and deactivate job ads.
*   **Staff Approval Workflow:**
    *   New job ads must be approved by a system staff member before becoming active.
    *   Employer profile updates must be verified by staff.
*   **Comprehensive CV Management:** Candidates can build their CVs by adding:
    *   Education History (Schools)
    *   Work Experience
    *   Known Languages
    *   Technical Skills/Technologies
    *   GitHub and LinkedIn profiles
    *   A personal biography
*   **Image Uploads:** Candidates can upload a profile picture, which is managed via Cloudinary.
*   **Job Favorites:** Candidates can save job advertisements to their favorites list.
*   **API Documentation:** Integrated Swagger UI for easy API exploration and testing.

### Database Schema
![database](https://github.com/user-attachments/assets/94dace52-0bd8-4da2-9288-a6fb4a1e5ed4)

## ⚙️ Setup and Running the Project

### Prerequisites
*   JDK 11 or higher
*   Apache Maven
*   PostgreSQL Database

### Configuration
1.  **Database:** The `src/main/resources/application.properties` file is empty. You need to add your PostgreSQL database configuration.
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/hrms_db
    spring.datasource.username=postgres
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    ```
2.  **Email Server:** Configure your email sender in `application.properties`. The `EmailManager` uses this to send verification links.
    ```properties
    spring.mail.host=smtp.example.com
    spring.mail.port=587
    spring.mail.username=your-email@example.com
    spring.mail.password=your-email-password
    spring.mail.properties.mail.smtp.auth=true
    spring.mail.properties.mail.smtp.starttls.enable=true
    ```
3.  **Cloudinary:** For security, it is strongly recommended to move your Cloudinary credentials from `CloudinaryService.java` to `application.properties`.
    ```properties
    # Add these to application.properties
    cloudinary.cloud_name=dldfibq4u
    cloudinary.api_key=515178569245171
    cloudinary.api_secret=OrNfDEele1JBl-xyN9YeFW7uCW4
    ```
    Then, inject these values into `CloudinaryService` using `@Value("${cloudinary.cloud_name}")`.

### Running the Application
1.  Clone the repository.
2.  Open a terminal in the root directory (`hrms-back-end-main`).
3.  Run the application using the Maven wrapper:
    ```bash
    ./mvnw spring-boot:run
    ```
4.  The API will be available at `http://localhost:8080`.

### API Documentation
Once the application is running, you can access the Swagger UI for interactive API documentation at:
**http://localhost:8080/swagger-ui.html**

##  REST API Endpoints

---

### Authentication & User Management (`/api/users`)

| Method | Endpoint                    | Description                                                               |
| :----- | :-------------------------- | :------------------------------------------------------------------------ |
| `POST` | `/api/users/login`          | Logs in a user. Returns user details and type (1:Cand, 2:Emp, 3:Staff).   |
| `GET`  | `/api/users/getall`         | Retrieves a list of all users.                                            |
| `GET`  | `/api/users/getVerifyedUsers` | Retrieves a list of all users who have verified their email.                |

---

### Candidate Management (`/api/candidates`)

| Method | Endpoint             | Description                                                         |
| :----- | :------------------- | :------------------------------------------------------------------ |
| `POST` | `/api/candidates/add`  | Registers a new candidate. Requires MERNIS validation and email verification. |
| `GET`  | `/api/candidates/getall` | Retrieves a list of all candidates.                                 |

---

### Employer Management (`/api/employer`)

| Method   | Endpoint                          | Description                                                                                             |
| :------- | :-------------------------------- | :------------------------------------------------------------------------------------------------------ |
| `POST`   | `/api/employer/add`               | Registers a new employer. Requires email verification and staff approval.                               |
| `GET`    | `/api/employer/getall`            | Retrieves a list of all employers.                                                                      |
| `GET`    | `/api/employer/getById`           | Retrieves a specific employer by their ID. `?id={employerId}`                                           |
| `PUT`    | `/api/employer/update`            | Submits a request to update employer profile information. This requires staff approval.                 |
| `PUT`    | `/api/employer/verifyUpdate`      | (Staff Only) Approves an employer's profile update request. `?employerUpdateId={id}&staffId={staffId}` |
| `GET`    | `/api/employerUpdate/getverifyed` | (Staff Only) Gets a list of employer update requests that are pending verification.                     |
| `GET`    | `/api/employerUpdate/getAll`      | (Staff Only) Gets a list of all employer update requests (pending and completed).                       |

---

### Staff & Approval Workflows (`/api/staff`, `/api/acticationbystaff`)

| Method | Endpoint                                 | Description                                                                         |
| :----- | :--------------------------------------- | :---------------------------------------------------------------------------------- |
| `POST` | `/api/staff/add`                         | (Admin) Creates a new staff member account.                                         |
| `GET`  | `/api/staff/getall`                      | Retrieves a list of all staff members.                                              |
| `GET`  | `/api/staff/findById`                    | Retrieves a staff member by ID. `?id={staffId}`                                     |
| `PUT`  | `/api/staff/update`                      | Updates a staff member's profile information.                                       |
| `GET`  | `/api/acticationbystaff/activateemployer`  | (Staff Only) Activates a newly registered employer. `?employerId={id}&staffId={id}` |
| `POST` | `/api/jobAd/setActive`                   | (Staff Only) Approves and activates a job ad. `?jobAdId={id}&staffId={id}`          |

---

### CV Management (`/api/cv`, `/api/images`, etc.)

| Method   | Endpoint                        | Description                                                                            |
| :------- | :------------------------------ | :------------------------------------------------------------------------------------- |
| `GET`    | `/api/cv/getByCandidateId`      | Get the full CV for a specific candidate. `?candidateId={id}`                            |
| `GET`    | `/api/cv/getByCvId`             | Get the full CV by its own ID. `?cvId={id}`                                              |
| `PUT`    | `/api/cv/updateGithub`          | Add or update the GitHub link on a CV. `?githublink={url}&cvId={id}`                     |
| `DELETE` | `/api/cv/deleteGithub`          | Remove the GitHub link from a CV. `?cvId={id}`                                           |
| `PUT`    | `/api/cv/updateLinkedin`        | Add or update the LinkedIn link on a CV. `?linkedinlink={url}&cvId={id}`                 |
| `DELETE` | `/api/cv/deleteLinkedin`        | Remove the LinkedIn link from a CV. `?cvId={id}`                                         |
| `PUT`    | `/api/cv/updateBiography`       | Add or update the biography on a CV. `?biography={text}&cvId={id}`                       |
| `DELETE` | `/api/cv/deleteBiography`       | Remove the biography from a CV. `?cvId={id}`                                             |
| `POST`   | `/api/images/upload`            | Upload a profile picture for a CV. `?cvId={id}` (Requires multipart file).               |
| `DELETE` | `/api/images/delete`            | Delete the profile picture from a CV. `?id={imageId}`                                    |
| `POST`   | `/api/school/addSchool`         | Add an education entry (school) to a CV.                                                 |
| `DELETE` | `/api/school/deleteSchool`      | Delete an education entry from a CV. `?schoolId={id}`                                    |
| `POST`   | `/api/experiances/add`          | Add a work experience entry to a CV.                                                     |
| `DELETE` | `/api/experiances/delete`       | Delete a work experience entry from a CV. `?experianceId={id}`                           |
| `POST`   | `/api/language/addLanguage`     | Add a language to a CV.                                                                |
| `DELETE` | `/api/language/deleteLanguage`  | Delete a language from a CV. `?languageId={id}`                                          |
| `POST`   | `/api/technology/addTechnology` | Add a technology/skill to a CV.                                                        |
| `DELETE` | `/api/technology/deleteTechnology`| Delete a technology/skill from a CV. `?technologyId={id}`                                |

---

### Job Advertisement Management (`/api/jobAd`)

| Method   | Endpoint                        | Description                                                                                      |
| :------- | :------------------------------ | :----------------------------------------------------------------------------------------------- |
| `POST`   | `/api/jobAd/create`             | (Employer) Creates a new job advertisement. It will be inactive until approved by staff.         |
| `POST`   | `/api/jobAd/setPassive`         | (Employer) Deactivates an active job ad. `?jobAdId={id}`                                         |
| `GET`    | `/api/jobAd/getall`             | Retrieves all job ads, regardless of status.                                                     |
| `GET`    | `/api/jobAd/getActiveAds`       | Retrieves all active and approved job ads.                                                       |
| `GET`    | `/api/jobAd/getByJobAdId`       | Retrieves a single job ad by its ID. `?id={jobAdId}`                                             |
| `GET`    | `/api/jobAd/getActivesOrderLastDate` | Retrieves all active job ads, sorted by application deadline.                                |
| `GET`    | `/api/jobAd/getActiveAndCompanyId`| Retrieves all active job ads for a specific employer. `?companyId={employerId}`                  |
| `GET`    | `/api/jobAd/getWaitingJobAds`   | (Staff Only) Retrieves job ads pending staff approval.                                           |
| `POST`   | `/api/jobAd/getByActiveAndFilter` | Retrieves active job ads with pagination and filtering. `?pageNo={num}&pageSize={num}`         |

---

### Job Ad Favorites (`/jobAdFavorites`)

| Method   | Endpoint                       | Description                                                         |
| :------- | :----------------------------- | :------------------------------------------------------------------ |
| `GET`    | `/jobAdFavorites/getByCandidateId` | Get all favorited job ads for a specific candidate. `?candidateId={id}` |
| `POST`   | `/jobAdFavorites/addFavorite`    | Adds a job ad to a candidate's favorites. `?candidateId={id}&jobAdId={id}` |
| `DELETE` | `/jobAdFavorites/removeFavorite` | Removes a job ad from favorites by its favorite ID. `?favoriteId={id}` |

---

### System Data & General Endpoints

| Method | Endpoint                        | Description                                                                  |
| :----- | :------------------------------ | :--------------------------------------------------------------------------- |
| `GET`  | `/api/activationcode/active/{code}` | Endpoint hit from the email link to verify a user's account.                 |
| `GET`  | `/city/getAll`                  | Retrieves a list of all cities.                                              |
| `GET`  | `/workPlace/getAll`             | Retrieves a list of all work place types (e.g., On-site, Remote).            |
| `GET`  | `/workTime/getAll`              | Retrieves a list of all work time types (e.g., Full-time, Part-time).        |
| `GET`  | `/api/jobpositions/getall`      | Retrieves a list of all available job positions/titles.                      |
| `POST` | `/api/jobpositions/add`         | (Staff Only) Adds a new job position to the system.                          |
