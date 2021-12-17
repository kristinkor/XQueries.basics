(: 
    https://riptutorial.com/xquery/example/16394/sum-over-values

    The Objective is to get the sum of all values (net income) 
    where the state is "NY" or "NJ" or "CT". The net income is located
    between the property tags

    <property state="NY" >2925.6</property>

    Command        
        .\run.cmd  .\queries\f07-data-TriState.xqy a07.xml

:)

<answer question="7">
{   
    let $file :=  fn:environment-variable("CITY_PROPERTIES")
    
    let $sum := fn:sum(for $x in doc($file)//property 
        where ($x/@state eq "NY" or $x/@state eq "NJ" or $x/@state eq "CT")
        return data($x))   
    
    return <sum state= "triState">     
          {$sum}
    </sum>
}
</answer>
