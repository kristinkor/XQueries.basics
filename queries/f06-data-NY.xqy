(: 
    https://riptutorial.com/xquery/example/16394/sum-over-values

    The Objective is to get the sum of all values (net income) 
    where the state = "NY". The net income is located
    between the property tags

    <property state="NY" >2925.6</property>

    Command
        .\run.cmd  .\queries\f06-data-NY.xqy a06.xml

:)

<answer question="6">
{     
    let $file :=  fn:environment-variable("CITY_PROPERTIES")
    
    let $sum := fn:sum(for $x in doc($file)//property 
        where $x/@state eq "NY"
        return data($x))    
    return <sum state= "NY">     
          {$sum}
        </sum>
}
</answer>
