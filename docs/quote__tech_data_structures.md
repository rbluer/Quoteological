
### Quoteological Documents
[Quoteological Documents - Table of Contents](index.md)

## Quoteological Tech - Data Structures


Quoteological is all about quotes, but yet it's more than just about a single type of a quote.

Quoteological is more than just one single type of data, and it's more than just one format and structure of those data.  In order to work with a wide variety of quote types, Quoteological needs to identify a unified way to express all of the possible variations in a logical format, as expressed through the external files that will hold the data, and as expressed as the data structures that will be used within the memory of this plugin.  

The benefit of formally structured data, is that the plugin would need minimal code to handle it.  The same code should handle all possible data sources and types.  As a result, the plugin can have very efficent code that has the least risk of having bugs.  The more usage code experiences, then the better chances that all possible bugs will be found and resolved, which leads to greater stability.


<hr style="height:3px; border:none; color:#aaf; background-color:#aaf;">


## Data Overview and Terminologies



<hr style="height:3px; border:none; color:#aaf; background-color:#aaf;">


## Data Control Structures

**Category** The category is the highest level of data, and it defines everything related to that category.  All data within a category will be identical in format and will share the same characteristics.  

**Collection** Some categories will have collections.  Collections will stand on its own and be a major grouping for the data. 

**group**

**section**

**line**


Example of how it applies to the category of Bibles.

```
category = Bible
collection = kjv
group = book
section = chapter
line = verse
```

<hr style="height:3px; border:none; color:#aaf; background-color:#aaf;">


## Data Details


<hr style="height:3px; border:none; color:#aaf; background-color:#aaf;">


## Data File Formats


<hr style="height:3px; border:none; color:#aaf; background-color:#aaf;">


## Data Indexing and Random Access

The simpliest way to access data, is to load it all in to memory so it is always there when you are wanting to use it. As great as this sounds, the major drawback is that it will require, and consume, a lot of memory.  And with a minecraft server, more memory costs money. 

So to minimize the amount of memory required to support multiple categories of data, the solution is to store the data on the server's directory storage, then access the data on demand, as needed.  To speed up the accessing of the data, we will emply the use of indexing.

Indexing is a way to take the raw, random length data, and to provide a unified structure to so software can calculate the beginning of each record so our plugin can quickly read that one data record, and only that one record.

This can be accomplished through the generation of an index file and then it can be used.  This is a fairly simple process.

Or an existing library can be used, such as SQLite, and let the library manage the indexing and accessing the data.


<hr style="height:3px; border:none; color:#aaf; background-color:#aaf;">



<hr style="height:7px; border:none; color:#aaf; background-color:#aaf;">


