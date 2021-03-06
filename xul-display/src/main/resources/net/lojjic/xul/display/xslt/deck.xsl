<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		xmlns:xul="http://www.mozilla.org/keymaster/gatekeeper/there.is.only.xul">

	<xsl:template match="xul:deck">
		<xsl:variable name="selectedIndex" select="number(@selectedIndex)" /> 
		<xsl:apply-templates select="*[position() = $selectedIndex + 1]" />
	</xsl:template>

</xsl:stylesheet>