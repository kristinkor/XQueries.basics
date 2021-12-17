(: 
   https://riptutorial.com/xquery/example/16394/sum-over-values

   The Objective is to get the sum of all values (net income) 
   where the state = "NM". The net income is located
   between the property tags
   
   <property state="NM" >2925.6</property>
    Command
        .\run.cmd  .\queries\f05-data-NM.xqy a05.xml


:)

<answer question="5">
{       
    let $file :=  fn:environment-variable("CITY_PROPERTIES")
    
    let $sum := fn:sum(for $x in doc($file)//property 
        where $x/@state eq "NM"
    return data($x))
    
    return <sum state= "NM">     
          {$sum}
        </sum>
}
</answer>
