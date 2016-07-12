[#ftl]

from xpto [ [#include "filter.ftl"] ]	
select  
	  "xpto" as situation
	, csId as id
	, str:concat("O consumo de Disco ou FS est� acima do threshold estipulado em 1%. Disco ou FS: "
		, fileSystem
		, ". Valor atual: "
		, value, "%" ) as message
	, hostname as hostname
	, fileSystem as item
	, value as value
	, "open" as eventstatus
	, "critical" as severity
	, "xpto" as threshold
	, businessService as businessService
	, technicalService as technicalService
	, serviceComponent as serviceComponent
	, environment as environment
	, lsFunction as lsFunction
	, hyperName as hyperName
	, csSite as csSite
	, platform as platform
	, rule as rule
	, status as status
	, timestamp as timestamp
	, tool as tool
insert into Saida;