

# A: Parse raw data to build common formatted file:
1. DONE: Choose file format and website:
  - URL:
  - Format: eng-web_vpl.zip
2. DONE: Parse zip file
3. DONE: Create data structure of target file output
4. DONE: Write to target output file, which is the standardized format.
  - Format: TSV, zip
5. File is now ready to be "distributed"


# B: Parse Standardized File to load in to sqLite database:
1. Read standardized input file (from step A.4).  Reuse data structure (from step A.3).
2. Create sqLite file
3. Parse standardized input file and write to database
4. Database file now ready to use

5. Create Indexes?
  - Primary key: category, collection, row, group, section, line
  - Row index: category, collection, row 
    - (note, first 3 columns of primary key, so this index is redundant)

6. May need to create a "catalog" table, which identifies the collections we have
  - category, collection, totalRows, groupCounts, sectionCounts
  - Use a sql select-insert statement?  

# C: Preprocess all database files on server startup
1. Identify all databases
2. collect all categories and collections, with total number of lines
3. Store in a "catalog" of all entries
4. Note, for random access, can use random number of total lines and read by row number.



