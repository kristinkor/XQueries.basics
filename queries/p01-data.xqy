(: 
    Environment Variables
    
        Data files....: CITY_PROPERTIES
        Answer files..: XQUERY_CITYTECH_HOME    
:)
let $file :=  fn:environment-variable("CITY_PROPERTIES")

for $x in doc($file)/properties/property
where $x/@cost > 140000
return $x