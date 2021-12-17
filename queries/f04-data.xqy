(: 
    Environment Variables
    
        Data files....: CITY_PROPERTIES
        Answer files..: XQUERY_CITYTECH_HOME   

    Description 

        1)  Display all the data where the cost is between 135,000 and 150,000
        2)  Show properties only that are from NY
        3)  Sort data in descending order by the cost property
        4)  Show all properties fields and content


    Command
        .\run.cmd .\queries\f04-data.xqy a04.xml

    Output file name: a04.xml

    Below is example of a sample row from the answer query   

        <answer question="4">
            <property id="H00300"
                    cost="141000"
                    downPayment="29610"
                    state="NY"

            </property>
        </answer>   
:)

<answer question="4">
{
    let $file :=  fn:environment-variable("CITY_PROPERTIES")
        for $x in doc($file)//property
        where $x/@cost >= 135000 and $x/@cost <= 150000 
        and $x/@state eq "NY"
        order by $x/@cost descending
    return $x
}
</answer>
