<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Candies</h2>
                <xsl:for-each select="candies/candy">
                    <xsl:sort select="@name"/>
                    <tr>
                        <table border="5">
                            <tr bgcolor="#FFFFE0">
                                <th>Attribute</th>
                                <th>Value</th>
                            </tr>
                            <tr>
                                <td>Name</td>
                                <td>
                                    <xsl:value-of select="@name"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Energy</td>
                                <td>
                                    <xsl:value-of select="energy"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Type</td>
                                <td>
                                    <xsl:value-of select="type"/>
                                </td>
                            </tr>
                            <tr>
                                <tr>
                                    <td>
                                        <b>Ingredients</b>
                                    </td>
                                </tr>
                            </tr>
                            <xsl:for-each select="ingredients/ingredient">
                                <xsl:choose>
                                    <xsl:when test="position() &lt;= 3">
                                        <tr>
                                            <td>
                                                <xsl:value-of select="name"/>
                                            </td>
                                            <td>
                                                <xsl:value-of select="quantity"/>
                                            </td>
                                        </tr>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:for-each>
                            <tr>
                                <td>
                                    <b>Values</b>
                                </td>
                            </tr>
                            <tr>
                                <td>Proteins</td>
                                <td>
                                    <xsl:value-of select="value/proteins"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Fats</td>
                                <td>
                                    <xsl:value-of select="value/fats"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Carbs</td>
                                <td>
                                    <xsl:value-of select="value/carbohydrates"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <br/>
                                </td>
                            </tr>
                            <tr>
                                <td>Production</td>
                                <td>
                                    <xsl:value-of select="production"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Description</td>
                                <td>
                                    <xsl:value-of select="description"/>
                                </td>
                            </tr>
                        </table>
                    </tr>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>