--create contacts table
CREATE TABLE CONTACTS(
    contact_id integer primary key,
    first_name text not null,
    last_name text not null,
    email text not null unique,
    phone text not null unique );

--create groups table
CREATE TABLE GROUPS(group_id integer primary key, name text not null);

--create contact_groups table
CREATE TABLE CONTACT_GROUPS(contact_id integer, group_id integer,
    PRIMARY KEY (contact_id, group_id),
    FOREIGN KEY (contact_id)
        REFERENCES contacts (contact_id)
            ON DELETE CASCADE
            ON UPDATE NO ACTION,
    FOREIGN KEY (group_id)
        REFERENCES groups (group_id)
        ON DELETE CASCADE
            ON UPDATE NO ACTION
);


--create view v_tracks

CREATE VIEW V_TRACKS
as 
SELECT
   trackid,
   tracks.name,
   albums.Title AS album,
   media_types.Name AS media,
   genres.Name AS genres
FROM
   tracks
INNER JOIN albums ON Albums.AlbumId = tracks.AlbumId
INNER JOIN media_types ON media_types.MediaTypeId = tracks.MediaTypeId
INNER JOIN genres ON genres.GenreId = tracks.GenreId;

-- This query gets data from the tracks, albums, media_types, and genres tables.
-- As you can see adding more operations to this query makes it difficult to read and open to defects. 
-- This is where views can come to the rescue. 


--create new view step 2
CREATE VIEW V_ALBUM_TRACKS(AlbumTitle, Minutes)
as
    SELECT album.title, SUM(millisecons)/60000
    FROM tracks
        INNER JOIN
        albums USING (AlbumId)
        GROUP BY AlbumTitle;


--Indexes
CREATE TABLE contactIndex (first_name text not null,
    last_name text not null,
    email text not null unique);

CREATE UNIQUE INDEX idx_contactIndex_email 
ON contactIndex (email);

-- let's test it out. 



INSERT INTO contactIndex (first_name, last_name, email)
VALUES('Johny','Doe','john.doe@mccneb.edu'); -- this should prevent us from inserting this record as the email is taken/in use. 

INSERT INTO contactIndex (first_name, last_name, email)
VALUES('David','Brown','david.brown@mccneb.edu'),
      ('Lisa','Smith','lisa.smith@mccneb.edu'); -- should be fine since there is not unique index contraint violation. 




EXPLAIN QUERY PLAN
SELECT * from contactIndex
where email = 'lisa.smith@sqlitetutorial.net';

-- test it with a valid email id 
--added id column value as ID is a not null value.
INSERT INTO leads (id, first_name, last_name, email, phone, source)
VALUES ('1234','John', 'Doe', 'john.doe@mccneb.edu', '4089009334','www');


DROP TRIGGER validate_email;

--this is the correct SQL script to show popularity
SELECT InvoiceId, invoice_items.TrackId, tracks.GenreID, genres.Name, count(genres.Name) as Count
FROM invoice_items
INNER JOIN tracks ON tracks.TrackId = invoice_items.TrackId
INNER JOIN genres ON genres.GenreID = tracks.GenreID
Group by genres.Name
order by Count desc

--I created a java Monstrosity to work around not knowing SQL enough using this SQL
SELECT InvoiceId, invoice_items.TrackId, tracks.GenreID, genres.Name
FROM invoice_items
INNER JOIN tracks ON tracks.TrackId = invoice_items.TrackId
INNER JOIN genres ON genres.GenreID = tracks.GenreID