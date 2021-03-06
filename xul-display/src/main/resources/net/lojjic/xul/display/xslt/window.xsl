<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		xmlns:xul="http://www.mozilla.org/keymaster/gatekeeper/there.is.only.xul">

	<xsl:template match="xul:window">
		<html>
			<head>
				<title><xsl:value-of select="@title" /></title>
				<style type="text/css">
					table {margin:0; border-collapse:collapse; border-spacing:0;}
					tr {vertical-align:top;}
					td {padding:0;}
					.label {display:block; white-space:nowrap;}
					input.textbox, textarea.textbox {width:100%;}
					select.menulist, select.listbox {width:100%;}
					.tab {border:1px solid; -moz-border-radius:4px 4px 0 0; cursor:default;}
					.tabpanel {border:1px solid;}

					table.tree {width:100%}
					table.tree thead th {border:2px outset #999; text-align:left;}
				</style>
			</head>
			<body>
				<xsl:apply-templates />
			</body>
		</html>
	</xsl:template>

</xsl:stylesheet>