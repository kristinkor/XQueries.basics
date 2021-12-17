(: 
   https://riptutorial.com/xquery/example/16394/sum-over-values

    1)  The Objective is to get the sum of all values (net income) 
        where the group = "10". The net income is located
        between the property tags.

    2) The owner of group 10, his estimated tax is based on his status
       as a single individual which a status = "s". Figure out his tax rate  

    3) Calculate tax paid based on derived taxRate

    sample output

    <answer question="18">
        <summary>
            <income>30000</income>
            <rule rate="0.12" status="s" range1="9950" range2="40524.9999"/>
            <taxPaid>30000</taxPaid>
        </summary>
    </answer>
:)

<answer question="18">
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
          <taxPaid>{$sum*$n/@rate}</taxPaid>
    </summary>
    }
</answer>

