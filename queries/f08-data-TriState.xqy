(: 
    https://riptutorial.com/xquery/example/16394/sum-over-values

    The Objective is to get the sum of all values (net income) 
    where the state is "NY" or "NJ" or "CT". The net income is located
    between the property tags

    1.  Get Sum of NY
    2.  Get sum of CT
    3.  Get sum of NJ

    <property state="NY" >2925.6</property>

    Command                
        .\run.cmd  .\queries\f08-data-TriState.xqy A08.XML

:)

<answer question="8">
{    
    let $file :=  fn:environment-variable("CITY_PROPERTIES")

    let $sumNY := fn:sum(for $x in doc($file)//property 
        where $x/@state eq "NY" 
        return data($x))
       
    let $sumNJ := fn:sum(for $x in doc($file)//property 
        where $x/@state eq "NJ" 
        return data($x))
    let $sumCT := fn:sum(for $x in doc($file)//property 
        where $x/@state eq "CT" 
        return data($x))
    let $states := ($sumNY, $sumNJ, $sumCT)
    let $sum := fn:sum($states )    
    return 
    <summary>
        <sum state= "NY">     
            {$sumNY}
        </sum>
            <sum state= "NJ">     
            {$sumNJ}
        </sum>
            <sum state= "CT">     
            {$sumCT}
        </sum>
        <sum state= "triState">     
            {$sum}
        </sum>
    </summary>    
}
</answer>