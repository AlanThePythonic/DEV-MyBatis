# DEV-MyBatis

For demonrating the MyBatis opertions :
  >> Select, Update, Delete, Insert

Select :
  >> One to One, One to Many
  
/* Create Table of User */..
CREATE TABLE user (
  user_id int(10) unsigned NOT NULL auto_increment,
  email_id varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  first_name varchar(45) NOT NULL,
  last_name varchar(45) default NULL,
  blog_id int(10) unsigned default NULL,
  PRIMARY KEY  (user_id),
  UNIQUE KEY Index_2_email_uniq (email_id),
  KEY FK_user_blog (blog_id),
  CONSTRAINT FK_user_blog FOREIGN KEY (blog_id) REFERENCES blog (blog_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/* Create Table of Blog */
CREATE TABLE blog (
  blog_id int(10) unsigned NOT NULL auto_increment,
  blog_name varchar(45) NOT NULL,
  created_on datetime NOT NULL,
  PRIMARY KEY  (blog_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/* Create Table of Post */
CREATE TABLE post (
  post_id int(10) unsigned NOT NULL auto_increment,
  title varchar(45) NOT NULL,
  content varchar(1024) NOT NULL,
  created_on varchar(45) NOT NULL,
  blog_id int(10) unsigned NOT NULL,
  PRIMARY KEY  (post_id),
  KEY FK_post_blog (blog_id),
  CONSTRAINT FK_post_blog FOREIGN KEY (blog_id) REFERENCES blog (blog_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


