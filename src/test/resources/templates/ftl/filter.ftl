[#ftl]
[#assign localCriterias = (criteria.subCriterias)!subCriterias]
[#assign localConditions = (criteria.conditions)!conditions]

[#if localConditions??]
	[#list localConditions as condition]
		${(condition.operator)!""} ${condition.field} ${condition.conditional.external} ${condition.value} 
	[/#list]
[/#if]

[#if localCriterias??]
	[#list localCriterias as criteria]
		([#include "filter.ftl"])
	[/#list]
[/#if]
