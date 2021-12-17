(: 
   https://riptutorial.com/xquery/example/16394/sum-over-values

    
    The Objective is to get the summary information
    for the tags below (net income). Net Income is located
    between the property tag
   
    <property state="NY" >2925.6</property>

:)

<answer question="9">
{
    let $file :=  fn:environment-variable("CITY_PROPERTIES")
    
    let $maxData := fn:max(for $x in doc($file)//property 
        where $x/@state eq "NY"
        return data($x))    
    let $minData := fn:min(for $x in doc($file)//property 
        where $x/@state eq "NY"
        return data($x))
    let $avgData := fn:avg(for $x in doc($file)//property 
        where $x/@state eq "NY"
        return data($x))  
    let $sumData := fn:sum(for $x in doc($file)//property 
        where $x/@state eq "NY"
        return data($x))



    return <summary>
               <max>{$maxData}</max>
               <min>{$minData}</min>               
               <avg>{$avgData}</avg>
               <sum>{$sumData}</sum>               
            </summary>
}
</answer>
