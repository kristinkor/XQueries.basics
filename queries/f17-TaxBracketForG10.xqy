(: 
   https://riptutorial.com/xquery/example/16394/sum-over-values

   1) The Objective is to get the sum of all values (net income) 
   where the group = "10". The net income is located
   between the property tags.

   2) The owner of group 10, his estimated tax is based on his status
      as a single individual which a status = "s". Figure out his tax rate  

   output

    <answer question="17">
        <summary>
            <income>nnn.nn</income>
            <rule rate="nn" status="s" range1="nnn" range2="nnnn"/>
        </summary>
    </answer>

:)
 
<answer question="17">
{     
    let $file :=  fn:environment-variable("CITY_PROPERTIES")
    
    let $sum := fn:sum(for $x in doc($file)//property 
        where $x/@group = 10
        return data($x))
    for $n in doc($file)//rule
    where $n/@status eq "s" and $n/@range1 <= $sum and $n/@range2 >= $sum
      
    return <summary>  
    <income>{$sum}</income>   
          {$n}
    </summary>
}
</answer>