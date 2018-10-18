-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 09, 2018 at 12:27 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `attendance_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE IF NOT EXISTS `attendance` (
  `date` date NOT NULL,
  `sapid` varchar(11) NOT NULL,
  `fid` varchar(10) NOT NULL,
  `sid` varchar(10) NOT NULL,
  `status` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `batch`
--

CREATE TABLE IF NOT EXISTS `batch` (
  `batchid` varchar(10) NOT NULL,
  `sapid` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `batch`
--

INSERT INTO `batch` (`batchid`, `sapid`) VALUES
('d1', '60003188001'),
('d1', '60003188002'),
('d1', '60003188003'),
('d2', '60003188004'),
('d2', '60003188005'),
('d2', '60003188006'),
('d3', '60003188007'),
('d3', '60003188008'),
('d3', '60003188009'),
('d4', '60003188010'),
('d4', '60003188011'),
('d4', '60003188012');

-- --------------------------------------------------------

--
-- Table structure for table `coordinator`
--

CREATE TABLE IF NOT EXISTS `coordinator` (
  `fid` varchar(10) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `coordinator`
--

INSERT INTO `coordinator` (`fid`, `password`) VALUES
('f05', 'pass@123');

-- --------------------------------------------------------

--
-- Table structure for table `d1`
--

CREATE TABLE IF NOT EXISTS `d1` (
  `date` date NOT NULL,
  `sapid` varchar(11) NOT NULL,
  `fid` varchar(10) NOT NULL,
  `sid` varchar(10) NOT NULL,
  `status` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `d2`
--

CREATE TABLE IF NOT EXISTS `d2` (
  `date` date NOT NULL,
  `sapid` varchar(11) NOT NULL,
  `fid` varchar(10) NOT NULL,
  `sid` varchar(10) NOT NULL,
  `status` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `d3`
--

CREATE TABLE IF NOT EXISTS `d3` (
  `date` date NOT NULL,
  `sapid` varchar(11) NOT NULL,
  `fid` varchar(10) NOT NULL,
  `sid` varchar(10) NOT NULL,
  `status` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `d4`
--

CREATE TABLE IF NOT EXISTS `d4` (
  `date` date NOT NULL,
  `sapid` varchar(11) NOT NULL,
  `fid` varchar(10) NOT NULL,
  `sid` varchar(10) NOT NULL,
  `status` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE IF NOT EXISTS `faculty` (
  `fid` varchar(10) NOT NULL,
  `name` varchar(25) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`fid`, `name`, `password`) VALUES
('f01', 'Neha', 'pass@123'),
('f02', 'Arjun', 'pass@123'),
('f03', 'Neepa', 'pass@123'),
('f04', 'Pranit', 'pass@123'),
('f05', 'Anusha', 'pass@123'),
('f06', 'Mitchal', 'pass@123'),
('f07', 'Manisha', 'pass@123'),
('f08', 'Shefali', 'pass2123'),
('f09', 'Stevina', 'pass@123');

-- --------------------------------------------------------

--
-- Table structure for table `faculty_subject`
--

CREATE TABLE IF NOT EXISTS `faculty_subject` (
  `fid` varchar(10) NOT NULL,
  `sid` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faculty_subject`
--

INSERT INTO `faculty_subject` (`fid`, `sid`) VALUES
('f01', 's01'),
('f02', 's01'),
('f03', 's02'),
('f04', 's02'),
('f05', 's03'),
('f06', 's03'),
('f07', 's04'),
('f08', 's05'),
('f09', 's06');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `sapid` varchar(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `password` varchar(50) NOT NULL,
  `batchid` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`sapid`, `name`, `password`, `batchid`) VALUES
('60003188001', 'Jigar', 'pass@123', 'd1'),
('60003188002', 'Neelam', 'pass@123', 'd1'),
('60003188003', 'Devanshi', 'pass@123', 'd1'),
('60003188004', 'Bhavin', 'pass@123', 'd2'),
('60003188005', 'Riya M', 'pass@123', 'd2'),
('60003188006', 'sachin', 'pass@123', 'd2'),
('60003188007', 'Ritu', 'pass@123', 'd3'),
('60003188008', 'Riya P', 'pass@123', 'd3'),
('60003188009', 'Renitha', 'pass@123', 'd3'),
('60003188010', 'Niraj', 'pass@123', 'd4'),
('60003188011', 'Dhryv', 'pass@123', 'd4'),
('60003188012', 'Priyam', 'pass@123', 'd4');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE IF NOT EXISTS `subject` (
  `sid` varchar(10) NOT NULL,
  `name` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`sid`, `name`) VALUES
('s01', 'DBMS'),
('s02', 'DS'),
('s03', 'LD'),
('s04', 'MATHS'),
('s05', 'PCOM'),
('s06', 'JAVA');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `batch`
--
ALTER TABLE `batch`
 ADD PRIMARY KEY (`sapid`);

--
-- Indexes for table `coordinator`
--
ALTER TABLE `coordinator`
 ADD PRIMARY KEY (`fid`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
 ADD PRIMARY KEY (`fid`);

--
-- Indexes for table `faculty_subject`
--
ALTER TABLE `faculty_subject`
 ADD PRIMARY KEY (`fid`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
 ADD PRIMARY KEY (`sapid`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
 ADD PRIMARY KEY (`sid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
