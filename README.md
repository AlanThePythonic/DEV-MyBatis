# DEV-MyBatis

For demonrating the MyBatis opertions :
  >> Select, Update, Delete, Insert

Select :
  >> One to One, One to Many

Tables Relationship : 
>> /* Create Table of User */..<br />
>> CREATE TABLE user (<br />
  >> user_id int(10) unsigned NOT NULL auto_increment,<br />
  >> email_id varchar(45) NOT NULL,<br />
  >> password varchar(45) NOT NULL,<br />
  >> first_name varchar(45) NOT NULL,<br />
  >> last_name varchar(45) default NULL,<br />
  >> blog_id int(10) unsigned default NULL,<br />
  >> PRIMARY KEY  (user_id),<br />
  >> UNIQUE KEY Index_2_email_uniq (email_id),<br />
  >> KEY FK_user_blog (blog_id),<br />
  >> CONSTRAINT FK_user_blog FOREIGN KEY (blog_id) REFERENCES blog (blog_id)<br />
>> ) ENGINE=InnoDB DEFAULT CHARSET=latin1;<br />
>> <br />
>> /* Create Table of Blog */<br />
>> CREATE TABLE blog (<br />
  >> blog_id int(10) unsigned NOT NULL auto_increment,<br />
  >> blog_name varchar(45) NOT NULL,<br />
  >> created_on datetime NOT NULL,<br />
  >> PRIMARY KEY  (blog_id)<br />
>> ) ENGINE=InnoDB DEFAULT CHARSET=latin1;<br />
>> <br />
>> /* Create Table of Post */<br />
>> CREATE TABLE post (<br />
  >> post_id int(10) unsigned NOT NULL auto_increment,<br />
  >> title varchar(45) NOT NULL,<br />
  >> content varchar(1024) NOT NULL,<br />
  >> created_on varchar(45) NOT NULL,<br />
  >> blog_id int(10) unsigned NOT NULL,<br />
  >> PRIMARY KEY  (post_id),<br />
  >> KEY FK_post_blog (blog_id),<br />
  >> CONSTRAINT FK_post_blog FOREIGN KEY (blog_id) REFERENCES blog (blog_id)<br />
>> ) ENGINE=InnoDB DEFAULT CHARSET=latin1;<br />


