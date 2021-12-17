(: 
    Environment Variables
    
        Data files....: CITY_PROPERTIES
        Answer files..: XQUERY_CITYTECH_HOME   

    Description 

        1)  Display all the data where the cost is between 110,000 and 120,000 
        2)  Show all properties



    command

        .\run.cmd .\queries\f01-data.xqy a01.xml

	or 

        java  -classpath ".\xquery.jar\;.\saxon9he.jar;.\saxon9-xqj.jar" edu.citytech.xml.course.JXQuery .\queries\f01-data.xqy a01.xml 


	Below is example of 2 rows from the answer query

        <answer question="1">
            <property id="H00018"
                        cost="114000"
                        downPayment="26220"
                        state="NE"
                        percentage="0.15">3933</property>
            <property id="H00021"
                        cost="114000"
                        downPayment="26220"
                        state="ND"
                        percentage="0.19">4981.8</property>
        </answer>
:)

<answer question="1">
{
    let $file :=  fn:environment-variable("CITY_PROPERTIES")
        for $x in doc($file)/properties/property
        where $x/@cost >= 110000 and $x/@cost <= 120000
    return $x
}
</answer>
