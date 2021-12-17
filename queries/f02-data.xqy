(: 
    Environment Variables
    
        Data files....: CITY_PROPERTIES
        Answer files..: XQUERY_CITYTECH_HOME   

    Description 

        1)  Display all the data where the cost is between 135,000 and 210,000
        2)  Show properties only that are from ND
        3)  Show all properties fields and content

    Output file name: a02.xml

    Below is example of 2 rows from the answer query   

        <answer question="2">
            <property id="H00300"
                    cost="141000"
                    downPayment="29610"
                    state="ND"

            </property>
        </answer>

   
:)

<answer question="2">
{
    let $file :=  fn:environment-variable("CITY_PROPERTIES")
        for $x in doc($file)/properties/property
        where $x/@cost >= 135000 and $x/@cost <= 210000 and $x/@state eq "ND"
    return $x
}
</answer>
