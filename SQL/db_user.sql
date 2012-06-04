-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 03, 2012 at 08:35 PM
-- Server version: 5.1.61
-- PHP Version: 5.3.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_user`
--

-- --------------------------------------------------------

--
-- Table structure for table `cncms_actionlist`
--

CREATE TABLE IF NOT EXISTS `cncms_actionlist` (
  `aid` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `routine` varchar(255) NOT NULL,
  `routinetype` varchar(255) NOT NULL,
  `permission` varchar(255) NOT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `cncms_actionlist`
--

INSERT INTO `cncms_actionlist` (`aid`, `name`, `description`, `routine`, `routinetype`, `permission`) VALUES
(1, 'Plain Text Add Screen', 'Add a standard text/html paragraph with a title header onto chosen page.', 'plaintext_addscreen', 'addscreen', 'pid_edit'),
(2, 'Themes Edit Screen', 'Shows a form for the user to select a theme for the site.', 'themes_selecttheme', 'editscreen', 'Admin'),
(3, 'Themes Save', 'Updates the theme specified in the database and shows the user a request to refresh page link.', 'themes_save', 'updaterecord', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `cncms_globalsettings`
--

CREATE TABLE IF NOT EXISTS `cncms_globalsettings` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `cncms_globalsettings`
--

INSERT INTO `cncms_globalsettings` (`uid`, `name`, `value`) VALUES
(1, 'defaulttheme', 'coolwater'),
(2, 'defaultbox', 'coolwater/box1.html'),
(3, 'static_url', 'http://aoicms/'),
(4, 'sitetitle', 'AOI :CMS:'),
(5, 'iconset', 'tango'),
(6, 'rich_text_editor', '3rdpartylibs/tinymce'),
(7, 'default_text_editor', 'rich');

-- --------------------------------------------------------

--
-- Table structure for table `cncms_metatags`
--

CREATE TABLE IF NOT EXISTS `cncms_metatags` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `parent` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `content` varchar(255) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `cncms_metatags`
--

INSERT INTO `cncms_metatags` (`uid`, `parent`, `name`, `content`) VALUES
(1, 'G', 'PageTitle', '%pagetitle%'),
(2, 'G', 'Generator', 'AOI :CMS: http://aoicms.sourceforge.net/');

-- --------------------------------------------------------

--
-- Table structure for table `cncms_pagecategories`
--

CREATE TABLE IF NOT EXISTS `cncms_pagecategories` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `weight` int(11) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `cncms_pagecategories`
--

INSERT INTO `cncms_pagecategories` (`uid`, `name`, `weight`) VALUES
(1, 'home', 10);

-- --------------------------------------------------------

--
-- Table structure for table `cncms_pagecontent`
--

CREATE TABLE IF NOT EXISTS `cncms_pagecontent` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `parent` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `routine` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `weight` int(11) NOT NULL,
  `read` varchar(50) NOT NULL,
  `edit` varchar(50) NOT NULL,
  `publish` varchar(1) NOT NULL,
  `Flags` varchar(5) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

--
-- Dumping data for table `cncms_pagecontent`
--

INSERT INTO `cncms_pagecontent` (`cid`, `parent`, `location`, `name`, `routine`, `content`, `weight`, `read`, `edit`, `publish`, `Flags`) VALUES
(3, 'G', '%right%', 'Login', 'authenticate_loginbox', '', 30, 'Everybody', 'Nobody', 'N', ''),
(5, 'G', '%right%', 'Admin Nav', 'htmlmanager_adminnav', '', 30, 'Admin', 'Nobody', 'N', 'A'),
(25, '8', '%center%', 'Action List', 'action_list', '', 10, 'Admin', 'Nobody', 'N', 'A'),
(8, '2', '%center%', 'AOI :CMS: General Error', 'htmlmanager_error', '', 10, 'Everybody', 'Nobody', 'N', 'C'),
(9, 'G', '%right%', '%sitetitle%', 'autonav_simplelist', '', 20, 'Everybody', 'Editor', 'Y', ''),
(10, '4', '%center%', 'Database Settings', 'config_showsettings', '', 10, 'Admin', 'Nobody', 'N', 'A'),
(11, '5', '%center%', 'Global Settings', 'globalsettings_editpage', '', 10, 'Admin', 'Nobody', 'N', 'A'),
(12, '6', '%center%', 'Select Theme', 'themes_selecttheme', '', 10, 'Admin', 'Nobody', 'N', 'A'),
(13, '7', '%center%', 'Page Header List', 'pageheader_listpages', '', 10, 'Admin', 'Nobody', 'N', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `cncms_pageheaders`
--

CREATE TABLE IF NOT EXISTS `cncms_pageheaders` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `read` varchar(50) NOT NULL,
  `edit` varchar(50) NOT NULL,
  `publish` varchar(1) NOT NULL,
  `flags` varchar(10) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `cncms_pageheaders`
--

INSERT INTO `cncms_pageheaders` (`pid`, `title`, `category`, `read`, `edit`, `publish`, `flags`) VALUES
(1, 'Welcome', 'home', 'Everybody', 'Admin', 'Y', 'H'),
(2, 'AOI :CMS:Message Page', 'aoicms_core', 'Everybody', 'Nobody', 'N', ''),
(4, 'Database Settings', 'aoicms_core', 'Admin', 'Nobody', 'N', 'A'),
(5, 'Global Settings', 'aoicms_core', 'Admin', 'Nobody', 'N', 'A'),
(6, 'Themes', 'aoicms_core', 'Admin', 'Nobody', 'N', 'A'),
(7, 'Page Header List', 'aoicms_core', 'Admin', 'Nobody', 'N', 'A'),
(8, 'Action List', 'aoicms_core', 'Admin', 'Nobody', 'N', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `cncms_photocategories`
--

CREATE TABLE IF NOT EXISTS `cncms_photocategories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `parent` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `cncms_photocategories`
--

INSERT INTO `cncms_photocategories` (`id`, `name`, `parent`) VALUES
(1, 'Web development', 0),
(2, 'Application development', 0),
(3, 'Linux', 0),
(4, 'Misc', 0),
(5, 'Php', 1),
(6, 'Mysql', 1),
(7, 'Javascript', 1),
(8, 'CSS', 1),
(9, 'C plus plus', 2),
(10, 'wxWidgets', 2),
(11, 'Tutorials', 3),
(12, 'My thoughts', 4),
(13, 'SubofPHP', 5);

-- --------------------------------------------------------

--
-- Table structure for table `cncms_users`
--

CREATE TABLE IF NOT EXISTS `cncms_users` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `group` varchar(255) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `cncms_users`
--

INSERT INTO `cncms_users` (`uid`, `username`, `password`, `group`) VALUES
(1, 'aoicms', 'letmein', 'Admin'),
(2, 'aoicmseditor', 'letmein', 'Editor'),
(3, 'aoicmscon', 'letmein', 'Contributor'),
(4, 'aoicmsuser', 'letmein', 'User');

-- --------------------------------------------------------

--
-- Table structure for table `crud_example`
--

CREATE TABLE IF NOT EXISTS `crud_example` (
  `uid` int(255) NOT NULL AUTO_INCREMENT,
  `var1` varchar(255) NOT NULL,
  `var2` varchar(255) NOT NULL,
  `int1` int(20) NOT NULL,
  `selector1` varchar(3) NOT NULL,
  `date` date NOT NULL,
  `text1` text NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `crud_example`
--

INSERT INTO `crud_example` (`uid`, `var1`, `var2`, `int1`, `selector1`, `date`, `text1`) VALUES
(1, 'varchar1', 'varchar2', 1, 'On', '2012-05-17', 'text1'),
(2, 'record2 var1', 'record2 var2', 2, 'Off', '2012-05-18', 'record2 text1');

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE IF NOT EXISTS `test` (
  `name` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`name`, `value`) VALUES
('name1', 'value1'),
('name2', 'value2');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
