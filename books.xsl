<!--
Create an XML document that contains information about books, including the book title,
author, year published, price, and availability. The document includes the following
elements:
• books: the root element that contains all book information
• book: a child element that represents a single book
• title: the title of the book
• author: the author of the book
• year: the year the book was published
• price: the price of the book
• available: the availability status of the book (either "yes" or "no")
Create an XSLT stylesheet that transforms the XML document into an HTML table that
Display the name and price of all books, but only highlight the name for books that are not
available.
-->

<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    tr,th{
                        padding:14px;          
                    }
                    .highlight{
                        color:darkorange;
                        font-weight:bold;
                    }
                </style>
            </head>
            <body><center>
            <h2>Book Details</h2>
            <table border="1">
                <tr bgcolor="darkcyan">
                    <th>Title</th>
                    <th>Author</th>
                    <th>Year</th>
                    <th>Price</th>
                    <th>Available</th>
                </tr>
                    
                <xsl:for-each select="books/b">
                <xsl:choose>
                    <xsl:when test="available=0">
                        <tr class='highlight'>
                            <td><xsl:value-of select="name"/></td>
                            <td><xsl:value-of select="author"/></td>
                            <td><xsl:value-of select="year"/></td>
                            <td><xsl:value-of select="price"/></td>
                            <td><xsl:value-of select="available"/></td>
                        </tr>
                    </xsl:when> 
                    <xsl:otherwise>
                        <tr>
                            <td><xsl:value-of select="name"/></td>
                            <td><xsl:value-of select="author"/></td>
                            <td><xsl:value-of select="year"/></td>
                            <td><xsl:value-of select="price"/></td>
                            <td><xsl:value-of select="available"/></td>
                        </tr>
                    </xsl:otherwise>
                </xsl:choose>
                    
                </xsl:for-each>
            </table> </center>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>

