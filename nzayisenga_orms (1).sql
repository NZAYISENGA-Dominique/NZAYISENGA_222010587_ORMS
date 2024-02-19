-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 11:41 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nzayisenga_orms`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteJobseeker` (IN `p_jobseeker_id` INT)   BEGIN
    DELETE FROM jobseeker
    WHERE jobseeker_ID = p_jobseeker_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertInterview` (IN `p_interview_id` INT, IN `p_job_id` INT, IN `p_jobseeker_id` INT, IN `p_interviewer_id` INT, IN `p_date` DATE, IN `p_time` TIME, IN `p_location` VARCHAR(50), IN `p_interview_type` VARCHAR(50), IN `p_interviewer_name` VARCHAR(40), IN `p_interview_feedback` VARCHAR(40), IN `p_interview_status` VARCHAR(40))   BEGIN
    INSERT INTO interview (
        interview_id,
        job_id,
        jobseeker_id,
        interviewer_id,
        date,
        time,
        location,
        interview_type,
        interviewer_name,
        interview_feedback,
        interview_status
    ) VALUES (
        p_interview_id,
        p_job_id,
        p_jobseeker_id,
        p_interviewer_id,
        p_date,
        p_time,
        p_location,
        p_interview_type,
        p_interviewer_name,
        p_interview_feedback,
        p_interview_status
    );
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertJob` (IN `p_job_id` INT, IN `p_recruiter_id` INT, IN `p_job_description` VARCHAR(50), IN `p_job_name` VARCHAR(40), IN `p_job_location` VARCHAR(40), IN `p_job_salary` VARCHAR(50), IN `p_posting_date` VARCHAR(40), IN `p_application_deadline` VARCHAR(40), IN `p_employment_type` VARCHAR(50), IN `p_job_requirements` VARCHAR(40), IN `p_department` VARCHAR(40), IN `p_status` VARCHAR(40))   BEGIN
    INSERT INTO job (
        job_id,
        recruiter_id,
        job_description,
        job_name,
        job_location,
        job_salary,
        posting_date,
        application_deadline,
        employment_type,
        job_requirements,
        department,
        status
    ) VALUES (
        p_job_id,
        p_recruiter_id,
        p_job_description,
        p_job_name,
        p_job_location,
        p_job_salary,
        p_posting_date,
        p_application_deadline,
        p_employment_type,
        p_job_requirements,
        p_department,
        p_status
    );
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertJobseeker` (IN `p_jobseeker_ID` INT, IN `p_jobseeker_name` VARCHAR(30), IN `p_jobseeker_phone` VARCHAR(40), IN `p_jobseeker_email_address` VARCHAR(50), IN `p_jobseeker_username` VARCHAR(60), IN `p_jobseeker_password` VARCHAR(20), IN `p_jobseeker_address` VARCHAR(40), IN `p_jobseeker_resume` VARCHAR(40), IN `p_jobseeker_disability` VARCHAR(50), IN `p_jobseeker_reference` VARCHAR(40), IN `p_application_date` VARCHAR(50), IN `p_status` VARCHAR(50))   BEGIN
    INSERT INTO jobseeker (
        jobseeker_ID,
        jobseeker_name,
        jobseeker_phone,
        jobseeker_email_address,
        jobseeker_username,
        jobseeker_password,
        jobseeker_address,
        jobseeker_resume,
        jobseeker_disability,
        jobseeker_reference,
        application_date,
        status
    ) VALUES (
        p_jobseeker_ID,
        p_jobseeker_name,
        p_jobseeker_phone,
        p_jobseeker_email_address,
        p_jobseeker_username,
        p_jobseeker_password,
        p_jobseeker_address,
        p_jobseeker_resume,
        p_jobseeker_disability,
        p_jobseeker_reference,
        p_application_date,
        p_status
    );
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertRecruiter` (IN `p_recruiter_id` INT, IN `p_recruiter_name` VARCHAR(50), IN `p_company_type` VARCHAR(100), IN `p_recruiter_address` VARCHAR(50), IN `p_recruiter_email` VARCHAR(50), IN `p_recruiter_description` VARCHAR(50), IN `p_recruiter_phone` VARCHAR(40), IN `p_industry` VARCHAR(50))   BEGIN
    INSERT INTO recruiter (
        recruiter_id,
        recruiter_name,
        company_type,
        recruiter_address,
        recruiter_email,
        recruiter_description,
        recruiter_phone,
        industry
    ) VALUES (
        p_recruiter_id,
        p_recruiter_name,
        p_company_type,
        p_recruiter_address,
        p_recruiter_email,
        p_recruiter_description,
        p_recruiter_phone,
        p_industry
    );
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `JobseekerWithSubquery` ()   BEGIN
    SELECT j.*, r.recruiter_name
    FROM jobseeker j
    LEFT JOIN (
        SELECT jobseeker_id, MAX(application_date) AS latest_application_date
        FROM application
        GROUP BY jobseeker_id
    ) AS subq ON j.jobseeker_id = subq.jobseeker_id
    LEFT JOIN application a ON j.jobseeker_id = a.jobseeker_id AND subq.latest_application_date = a.application_date
    LEFT JOIN jobseeker_reference r ON j.jobseeker_reference = r.reference_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateJobseekerInformation` (IN `p_jobseeker_id` INT, IN `p_new_name` VARCHAR(30), IN `p_new_phone` VARCHAR(40), IN `p_new_email_address` VARCHAR(50), IN `p_new_username` VARCHAR(60), IN `p_new_password` VARCHAR(20), IN `p_new_address` VARCHAR(40), IN `p_new_resume` VARCHAR(40), IN `p_new_disability` VARCHAR(50), IN `p_new_reference` VARCHAR(40), IN `p_new_application_date` VARCHAR(50), IN `p_new_status` VARCHAR(50))   BEGIN
    UPDATE jobseeker
    SET
        jobseeker_name = p_new_name,
        jobseeker_phone = p_new_phone,
        jobseeker_email_address = p_new_email_address,
        jobseeker_username = p_new_username,
        jobseeker_password = p_new_password,
        jobseeker_address = p_new_address,
        jobseeker_resume = p_new_resume,
        jobseeker_disability = p_new_disability,
        jobseeker_reference = p_new_reference,
        application_date = p_new_application_date,
        status = p_new_status
    WHERE jobseeker_ID = p_jobseeker_id;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `all_jobs`
--

CREATE TABLE `all_jobs` (
  `job_id` int(11) DEFAULT NULL,
  `job_description` varchar(50) DEFAULT NULL,
  `job_name` varchar(40) DEFAULT NULL,
  `job_location` varchar(40) DEFAULT NULL,
  `job_salary` varchar(50) DEFAULT NULL,
  `posting_date` varchar(40) DEFAULT NULL,
  `application_deadline` varchar(40) DEFAULT NULL,
  `employment_type` varchar(50) DEFAULT NULL,
  `job_requirements` varchar(40) DEFAULT NULL,
  `department` varchar(40) DEFAULT NULL,
  `status` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `all_jobseekers`
--

CREATE TABLE `all_jobseekers` (
  `jobseeker_id` int(11) DEFAULT NULL,
  `jobseeker_name` varchar(30) DEFAULT NULL,
  `jobseeker_phone` varchar(40) DEFAULT NULL,
  `jobseeker_email_address` varchar(50) DEFAULT NULL,
  `jobseeker_username` varchar(60) DEFAULT NULL,
  `jobseeker_password` varchar(20) DEFAULT NULL,
  `jobseeker_address` varchar(40) DEFAULT NULL,
  `jobseeker_resume` varchar(40) DEFAULT NULL,
  `jobseeker_disability` varchar(50) DEFAULT NULL,
  `jobseeker_reference` varchar(40) DEFAULT NULL,
  `application_date` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `all_offer`
--

CREATE TABLE `all_offer` (
  `offer_id` int(11) DEFAULT NULL,
  `job_id` int(11) DEFAULT NULL,
  `jobseeker_id` int(11) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `benefit` varchar(50) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `offer_status` varchar(50) DEFAULT NULL,
  `reason_for_status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `all_placement`
--

CREATE TABLE `all_placement` (
  `placement_id` int(11) DEFAULT NULL,
  `job_id` int(11) DEFAULT NULL,
  `jobseeker_id` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `job_name` varchar(50) DEFAULT NULL,
  `company_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `all_recruiters`
--

CREATE TABLE `all_recruiters` (
  `recruiter_id` int(11) DEFAULT NULL,
  `recruiter_name` varchar(50) DEFAULT NULL,
  `company_type` varchar(100) DEFAULT NULL,
  `recruiter_address` varchar(50) DEFAULT NULL,
  `recruiter_email` varchar(50) DEFAULT NULL,
  `recruiter_description` varchar(50) DEFAULT NULL,
  `recruiter_phone` varchar(40) DEFAULT NULL,
  `industry` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `all_resume`
--

CREATE TABLE `all_resume` (
  `jobseeker_id` int(11) DEFAULT NULL,
  `education` varchar(40) DEFAULT NULL,
  `skills` varchar(40) DEFAULT NULL,
  `work_experiance` int(11) DEFAULT NULL,
  `languages` varchar(40) DEFAULT NULL,
  `jobseeker_address` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `application`
--

CREATE TABLE `application` (
  `application_id` int(11) NOT NULL,
  `jobseeker_id` int(11) DEFAULT NULL,
  `job_name` varchar(40) DEFAULT NULL,
  `application_date` varchar(150) DEFAULT NULL,
  `status` varchar(225) DEFAULT NULL,
  `institution` varchar(40) DEFAULT NULL,
  `action` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `application`
--

INSERT INTO `application` (`application_id`, `jobseeker_id`, `job_name`, `application_date`, `status`, `institution`, `action`) VALUES
(1, 1, 'manager', '0000-00-00', 'application_received', 'gicumbi_district', 'hide'),
(4, 1, 'manager', 'application_received', '2023/10/20', 'gicumbi_district', 'hide'),
(5, 1, 'manager', 'application_received', '2023/10/20', 'gicumbi_district', 'hide'),
(6, 1, 'manager', 'application_received', '2023/10/20', 'gicumbi_district', 'hide'),
(7, 1, 'manager', 'application_received', '0000-00-00', 'gicumbi_district', 'hide'),
(8, 1, 'manager', '2023/10/20', 'application_received', 'gicumbi_district', 'hide');

-- --------------------------------------------------------

--
-- Table structure for table `delete_info`
--

CREATE TABLE `delete_info` (
  `placement_id` int(11) DEFAULT NULL,
  `job_id` int(11) DEFAULT NULL,
  `jobseeker_id` varchar(40) DEFAULT NULL,
  `start_date` varchar(40) DEFAULT NULL,
  `end_date` varchar(11) DEFAULT NULL,
  `job_name` varchar(50) DEFAULT NULL,
  `company_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `insert_application_data`
--

CREATE TABLE `insert_application_data` (
  `application_id` varchar(1) DEFAULT NULL,
  `jobseeker_id` varchar(3) DEFAULT NULL,
  `job_name` varchar(10) DEFAULT NULL,
  `application_date` varchar(10) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `institution` varchar(9) DEFAULT NULL,
  `action` varchar(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `insert_interview_data`
--

CREATE TABLE `insert_interview_data` (
  `interview_id` varchar(1) DEFAULT NULL,
  `job_id` varchar(1) DEFAULT NULL,
  `jobseeker_id` varchar(1) DEFAULT NULL,
  `interviewer_id` varchar(1) DEFAULT NULL,
  `date` varchar(10) DEFAULT NULL,
  `time` varchar(5) DEFAULT NULL,
  `location` varchar(13) DEFAULT NULL,
  `interview_type` varchar(5) DEFAULT NULL,
  `interviewer_name` varchar(9) DEFAULT NULL,
  `interview_feedback` varchar(4) DEFAULT NULL,
  `interview_status` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `insert_jobseeker_data`
--

CREATE TABLE `insert_jobseeker_data` (
  `jobseeker_id` varchar(3) DEFAULT NULL,
  `jobseeker_name` varchar(10) DEFAULT NULL,
  `jobseeker_phone` varchar(10) DEFAULT NULL,
  `jobseeker_email_address` varchar(20) DEFAULT NULL,
  `jobseeker_username` varchar(20) DEFAULT NULL,
  `jobseeker_password` varchar(13) DEFAULT NULL,
  `jobseeker_address` varchar(7) DEFAULT NULL,
  `jobseeker_resume` varchar(2) DEFAULT NULL,
  `jobseeker_disability` varchar(4) DEFAULT NULL,
  `reference` varchar(18) DEFAULT NULL,
  `application_date` varchar(10) DEFAULT NULL,
  `status` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `insert_job_data`
--

CREATE TABLE `insert_job_data` (
  `job_id` varchar(1) DEFAULT NULL,
  `recruiter_id` varchar(1) DEFAULT NULL,
  `job_name` varchar(17) DEFAULT NULL,
  `location` varchar(13) DEFAULT NULL,
  `job_salary` varchar(6) DEFAULT NULL,
  `posting_date` varchar(10) DEFAULT NULL,
  `application_deadline` varchar(10) DEFAULT NULL,
  `employment_type` varchar(9) DEFAULT NULL,
  `job_requirement` varchar(16) DEFAULT NULL,
  `department` varchar(22) DEFAULT NULL,
  `status` varchar(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `insert_offer_data`
--

CREATE TABLE `insert_offer_data` (
  `offer_id` varchar(3) DEFAULT NULL,
  `job_id` varchar(3) DEFAULT NULL,
  `jobseeker_id` varchar(3) DEFAULT NULL,
  `salary` varchar(6) DEFAULT NULL,
  `benefit` varchar(11) DEFAULT NULL,
  `start_date` varchar(10) DEFAULT NULL,
  `end_date` varchar(10) DEFAULT NULL,
  `offer_status` varchar(8) DEFAULT NULL,
  `reason_for_status` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `insert_placement_data`
--

CREATE TABLE `insert_placement_data` (
  `placement_id` varchar(3) DEFAULT NULL,
  `job_id` varchar(2) DEFAULT NULL,
  `jobseeker_id` varchar(3) DEFAULT NULL,
  `start_date` varchar(10) DEFAULT NULL,
  `end_date` varchar(10) DEFAULT NULL,
  `job_name` varchar(4) DEFAULT NULL,
  `company_name` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `insert_recruiter_data`
--

CREATE TABLE `insert_recruiter_data` (
  `RECRUITER_ID` varchar(2) DEFAULT NULL,
  `RECRUITER_NAME` varchar(7) DEFAULT NULL,
  `COMPANY_TYPE` varchar(7) DEFAULT NULL,
  `RECRUITER_ADDRESS` varchar(10) DEFAULT NULL,
  `RECRUITER_EMAIL` varchar(17) DEFAULT NULL,
  `RECRUITER_DESCRIPTION` varchar(55) DEFAULT NULL,
  `RECRUITER_PHONE` varchar(10) DEFAULT NULL,
  `INDUSTRY` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `insert_resume_data`
--

CREATE TABLE `insert_resume_data` (
  `Resume_id` varchar(3) DEFAULT NULL,
  `jobseeker_id` varchar(3) DEFAULT NULL,
  `education` varchar(15) DEFAULT NULL,
  `skills` varchar(43) DEFAULT NULL,
  `work_experiance` varchar(19) DEFAULT NULL,
  `languages` varchar(37) DEFAULT NULL,
  `jobseeker_address` varchar(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `interview`
--

CREATE TABLE `interview` (
  `interview_id` int(11) NOT NULL,
  `job_id` int(11) DEFAULT NULL,
  `jobseeker_id` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `interview_type` varchar(50) DEFAULT NULL,
  `interview_name` varchar(40) DEFAULT NULL,
  `interview_feedback` varchar(40) DEFAULT NULL,
  `interview_status` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `interview`
--

INSERT INTO `interview` (`interview_id`, `job_id`, `jobseeker_id`, `date`, `time`, `location`, `interview_type`, `interview_name`, `interview_feedback`, `interview_status`) VALUES
(2, 1, 1, '2024-02-18', 9, 'Company Office', 'Technical', 'Interview with Manager', 'Positive feedback', 'Scheduled'),
(4, 3, 1, '2024-02-20', 11, 'Company Office', 'Technical', 'Second Round Interview', 'Neutral feedback', 'Completed'),
(5, 2, 1, '2024-02-21', 12, 'Company Office', 'Technical', 'Technical Assessment', 'Negative feedback', 'Completed'),
(6, 1, 1, '2024-02-22', 13, 'Remote', 'HR', 'Final Interview', 'Positive feedback', 'Scheduled');

-- --------------------------------------------------------

--
-- Table structure for table `job`
--

CREATE TABLE `job` (
  `job_id` int(11) NOT NULL,
  `recruiter_id` int(11) DEFAULT NULL,
  `job_description` varchar(50) DEFAULT NULL,
  `job_name` varchar(40) DEFAULT NULL,
  `job_location` varchar(40) DEFAULT NULL,
  `job_salary` varchar(50) DEFAULT NULL,
  `posting_date` varchar(40) DEFAULT NULL,
  `application_deadline` varchar(40) DEFAULT NULL,
  `employment_type` varchar(50) DEFAULT NULL,
  `job_requirements` varchar(40) DEFAULT NULL,
  `department` varchar(40) DEFAULT NULL,
  `status` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `job`
--

INSERT INTO `job` (`job_id`, `recruiter_id`, `job_description`, `job_name`, `job_location`, `job_salary`, `posting_date`, `application_deadline`, `employment_type`, `job_requirements`, `department`, `status`) VALUES
(1, 1, 'prepare of salary of workers', 'financial manager', '3000001', '20_09_2023', 'full_time', 'financial manager', 'full_time', 'bachlors in financial accounting', 'management', 'pending'),
(2, 1, 'financial manager', 'prepare of salary of workers', '300000', '20_09_2023', 'full_time', '29_09_2023', 'full_time', 'bachlors in financial accounting', 'management', 'pending'),
(3, 1, 'prepare of salary of workers', 'financial manager', 'full_time', 'full_time', 'full_time', 'financial manager', 'full_time', 'bachlors in financial accounting', 'management', 'pending'),
(4, 1, 'financial manager', 'prepare of salary of workers', '30000000', 'full_time', 'full_time', '29_09_2021', 'full_time', 'bachlors in financial accounting', 'management', 'pending'),
(5, 1, 'financial manager', 'prepare of salary of workers', 'full_time', 'full_time', 'full_time', '29_09_2024', 'full_time', 'bachlors in financial accounting', 'management', 'pending'),
(6, 1, 'financial manager', 'prepare of salary of workers', '20_09_2023', 'full_time', 'full_time', 'financial manager', 'full_time', 'bachlors in financial accounting', 'management', 'pending');

-- --------------------------------------------------------

--
-- Table structure for table `jobseeker`
--

CREATE TABLE `jobseeker` (
  `jobseeker_name` varchar(30) DEFAULT NULL,
  `jobseeker_phone` varchar(40) DEFAULT NULL,
  `jobseeker_email_address` varchar(50) DEFAULT NULL,
  `jobseeker_id` int(11) NOT NULL,
  `jobseeker_username` varchar(60) DEFAULT NULL,
  `jobseeker_password` varchar(20) DEFAULT NULL,
  `jobseeker_address` varchar(40) DEFAULT NULL,
  `jobseeker_resume` varchar(40) DEFAULT NULL,
  `jobseeker_disability` varchar(50) DEFAULT NULL,
  `jobseeker_reference` varchar(40) DEFAULT NULL,
  `application_date` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jobseeker`
--

INSERT INTO `jobseeker` (`jobseeker_name`, `jobseeker_phone`, `jobseeker_email_address`, `jobseeker_id`, `jobseeker_username`, `jobseeker_password`, `jobseeker_address`, `jobseeker_resume`, `jobseeker_disability`, `jobseeker_reference`, `application_date`, `status`) VALUES
('muvunyi', '0737352709', 'muvunyi@gmail.com', 1, 'muvunyi', 'muvunyi12@', 'kigali_gasabo', 'CV', 'none', 'ishimwe_0787878932', '20_09_2023', 'shortlisted'),
('Alice Johnson', '1234567890', 'alice@example.com', 7, 'alice123', 'password123', '123 Elm Street', 'alice_resume.pdf', 'None', 'Bob Smith', '2024-02-18', 'Active'),
('Bob Smith', '9876543210', 'bob@example.com', 8, 'bob123', 'password456', '456 Oak Avenue', 'bob_resume.pdf', 'Visual impairment', 'Alice Johnson', '2024-02-19', 'Active'),
('muvunyi', '0737352709', 'muvunyi@gmail.com', 10, '', 'muvunyi12@', 'kigali_gasabo', 'CV', 'none', 'ishimwe_0787878932', '20_09_2023', 'shortlisted'),
('Alice Johnson', '1234567890', 'alice@example.com', 11, 'rtghgfrdfg', 'password123', '123 Elm Street', 'alice_resume.pdf', 'None', 'Bob Smith', '2024-02-18', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `jobseeker_with_max_offer`
--

CREATE TABLE `jobseeker_with_max_offer` (
  `jobseeker_id` int(11) DEFAULT NULL,
  `jobseeker_name` varchar(30) DEFAULT NULL,
  `jobseeker_email_address` varchar(50) DEFAULT NULL,
  `jobseeker_phone` varchar(40) DEFAULT NULL,
  `max_offer_salary` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `offer`
--

CREATE TABLE `offer` (
  `offer_id` int(11) NOT NULL,
  `job_id` int(11) DEFAULT NULL,
  `jobseeker_id` int(11) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `benefit` varchar(50) DEFAULT NULL,
  `start_date` varchar(10) DEFAULT NULL,
  `end_date` varchar(11) DEFAULT NULL,
  `Offer_Status` varchar(50) DEFAULT NULL,
  `reason_for_status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `offer`
--

INSERT INTO `offer` (`offer_id`, `job_id`, `jobseeker_id`, `salary`, `benefit`, `start_date`, `end_date`, `Offer_Status`, `reason_for_status`) VALUES
(1, 1, 1, 300000, 'get experience', '2023-10-02', '2024-10-02', 'accepted', 'do not delay'),
(2, 1, 1, 300000, 'get experience', '2023-10-02', '2024-10-02', 'accepted', 'do not delay');

-- --------------------------------------------------------

--
-- Table structure for table `placement`
--

CREATE TABLE `placement` (
  `placement_id` int(11) NOT NULL,
  `job_id` int(11) DEFAULT NULL,
  `jobseeker_id` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `job_name` varchar(50) DEFAULT NULL,
  `company_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `placement`
--

INSERT INTO `placement` (`placement_id`, `job_id`, `jobseeker_id`, `start_date`, `end_date`, `job_name`, `company_name`) VALUES
(3, 1, 1, '2024-02-18', '2024-02-20', 'Software Engineer', 'ABC Company'),
(4, 1, 1, '2024-02-18', '2024-02-20', 'Software Engineer', 'ABC Company'),
(6, 2, 11, '2024-02-21', '2024-02-23', 'Marketing Specialist', 'Marketing Innovations'),
(7, 5, 1, '2024-02-22', '2024-02-24', 'Financial Analyst', 'Finance Dynamics'),
(8, 1, 1, '2024-02-18', '2024-02-20', 'Software Engineer', 'ABC Company');

-- --------------------------------------------------------

--
-- Table structure for table `recruiter`
--

CREATE TABLE `recruiter` (
  `recruiter_id` int(11) NOT NULL,
  `recruiter_name` varchar(50) DEFAULT NULL,
  `company_type` varchar(100) DEFAULT NULL,
  `recruiter_address` varchar(50) DEFAULT NULL,
  `recruiter_email` varchar(50) DEFAULT NULL,
  `recruiter_description` varchar(50) DEFAULT NULL,
  `recruiter_phone` varchar(40) DEFAULT NULL,
  `industry` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `recruiter`
--

INSERT INTO `recruiter` (`recruiter_id`, `recruiter_name`, `company_type`, `recruiter_address`, `recruiter_email`, `recruiter_description`, `recruiter_phone`, `industry`) VALUES
(1, 'private', 'private', 'Byumba_Gicumbi', 'gicumbi@gmail.com', 'prepare salary of workers', '0737352709', 'gicumbi'),
(2, 'private', 'private', 'Byumba_Gicumbi', 'gicumbi@gmail.com', 'prepare salary of workers', '0737352709', 'gicumbi'),
(3, 'private', 'private', 'Byumba_Gicumbi', 'gicumbi@gmail.com', 'prepare salary of workers', '0737352709', 'gicumbi');

-- --------------------------------------------------------

--
-- Table structure for table `resume`
--

CREATE TABLE `resume` (
  `Resume_id` int(11) NOT NULL,
  `jobseeker_id` int(11) DEFAULT NULL,
  `education` varchar(40) DEFAULT NULL,
  `skills` varchar(40) DEFAULT NULL,
  `work_experiance` int(11) DEFAULT NULL,
  `languages` varchar(40) DEFAULT NULL,
  `jobseeker_address` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `resume`
--

INSERT INTO `resume` (`Resume_id`, `jobseeker_id`, `education`, `skills`, `work_experiance`, `languages`, `jobseeker_address`) VALUES
(1, 1, 'bachlors degree', 'I am experienced to information  technol', 5, 'kinyarwanda_english_french', 'kigali_gasabo'),
(2, 1, 'bachlors degree', 'I am experienced to information  technol', 5, 'kinyarwanda_english_french', 'kigali_gasabo');

-- --------------------------------------------------------

--
-- Table structure for table `updateapplication`
--

CREATE TABLE `updateapplication` (
  `Application_id` int(11) DEFAULT NULL,
  `jobseeker_id` int(11) DEFAULT NULL,
  `job_name` varchar(40) DEFAULT NULL,
  `application_date` date DEFAULT NULL,
  `status` varchar(40) DEFAULT NULL,
  `institution` varchar(40) DEFAULT NULL,
  `action` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `update_info`
--

CREATE TABLE `update_info` (
  `recruiter_id` int(11) DEFAULT NULL,
  `recruiter_name` varchar(50) DEFAULT NULL,
  `company_type` varchar(100) DEFAULT NULL,
  `recruiter_address` varchar(50) DEFAULT NULL,
  `recruiter_email` varchar(50) DEFAULT NULL,
  `recruiter_description` varchar(50) DEFAULT NULL,
  `recruiter_phone` varchar(40) DEFAULT NULL,
  `industry` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `application`
--
ALTER TABLE `application`
  ADD PRIMARY KEY (`application_id`),
  ADD KEY `fk_application_jobseeker` (`jobseeker_id`);

--
-- Indexes for table `interview`
--
ALTER TABLE `interview`
  ADD PRIMARY KEY (`interview_id`),
  ADD KEY `fk_interview_job` (`job_id`),
  ADD KEY `fk_interview_jobseeker` (`jobseeker_id`);

--
-- Indexes for table `job`
--
ALTER TABLE `job`
  ADD PRIMARY KEY (`job_id`),
  ADD KEY `fk_job_recruiter` (`recruiter_id`);

--
-- Indexes for table `jobseeker`
--
ALTER TABLE `jobseeker`
  ADD PRIMARY KEY (`jobseeker_id`);

--
-- Indexes for table `offer`
--
ALTER TABLE `offer`
  ADD PRIMARY KEY (`offer_id`),
  ADD KEY `fk_offer_job` (`job_id`),
  ADD KEY `fk_offer_jobseeker` (`jobseeker_id`) USING BTREE;

--
-- Indexes for table `placement`
--
ALTER TABLE `placement`
  ADD PRIMARY KEY (`placement_id`),
  ADD KEY `fk_placement_job` (`job_id`),
  ADD KEY `fk_placement_jobseeker` (`jobseeker_id`);

--
-- Indexes for table `recruiter`
--
ALTER TABLE `recruiter`
  ADD PRIMARY KEY (`recruiter_id`);

--
-- Indexes for table `resume`
--
ALTER TABLE `resume`
  ADD PRIMARY KEY (`Resume_id`),
  ADD KEY `fk_resume_jobseeker` (`jobseeker_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `application`
--
ALTER TABLE `application`
  MODIFY `application_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `interview`
--
ALTER TABLE `interview`
  MODIFY `interview_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `job`
--
ALTER TABLE `job`
  MODIFY `job_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `jobseeker`
--
ALTER TABLE `jobseeker`
  MODIFY `jobseeker_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `offer`
--
ALTER TABLE `offer`
  MODIFY `offer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `placement`
--
ALTER TABLE `placement`
  MODIFY `placement_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `recruiter`
--
ALTER TABLE `recruiter`
  MODIFY `recruiter_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `resume`
--
ALTER TABLE `resume`
  MODIFY `Resume_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `application`
--
ALTER TABLE `application`
  ADD CONSTRAINT `fk_application_jobseeker` FOREIGN KEY (`jobseeker_id`) REFERENCES `jobseeker` (`jobseeker_id`);

--
-- Constraints for table `interview`
--
ALTER TABLE `interview`
  ADD CONSTRAINT `fk_interview_job` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`),
  ADD CONSTRAINT `fk_interview_jobseeker` FOREIGN KEY (`jobseeker_id`) REFERENCES `jobseeker` (`jobseeker_id`);

--
-- Constraints for table `job`
--
ALTER TABLE `job`
  ADD CONSTRAINT `fk_job_recruiter` FOREIGN KEY (`recruiter_id`) REFERENCES `recruiter` (`recruiter_id`);

--
-- Constraints for table `offer`
--
ALTER TABLE `offer`
  ADD CONSTRAINT `fk_offer_job` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`),
  ADD CONSTRAINT `fk_offer_jobseeker` FOREIGN KEY (`jobseeker_id`) REFERENCES `jobseeker` (`jobseeker_id`);

--
-- Constraints for table `placement`
--
ALTER TABLE `placement`
  ADD CONSTRAINT `fk_placement_job` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`),
  ADD CONSTRAINT `fk_placement_jobseeker` FOREIGN KEY (`jobseeker_id`) REFERENCES `jobseeker` (`jobseeker_id`);

--
-- Constraints for table `resume`
--
ALTER TABLE `resume`
  ADD CONSTRAINT `fk_resume_jobseeker` FOREIGN KEY (`jobseeker_id`) REFERENCES `jobseeker` (`jobseeker_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
