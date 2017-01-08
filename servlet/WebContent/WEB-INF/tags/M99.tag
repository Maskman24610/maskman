<%@tag  %>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%> 
<table border='1' width='100%'>
<c:forEach begin='1' end='4' var='r'>
	<tr>
	    <c:forEach begin='2' end='5' var='y'>
	    <td>
		    <c:forEach begin='1' end='9' var='x'>
					${y+4*(r-1)} X  ${x }= ${(y+4*(r-1))*x} <br>	  
			</c:forEach>
			</td>
		</c:forEach>
	</tr>
	</c:forEach>
</table>