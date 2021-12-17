(: 
   https://riptutorial.com/xquery/example/16394/sum-over-values

    1)  The Objective is to get the sum of all values (net income) 
        where the group = "1". The net income is located
        between the property tags.

    2) The owner of group 1, his estimated tax is based on his
       status = "mfj". Figure out his tax rate  

    3) Calculate tax paid based on derived taxRate

   output

    <answer question="19">
        <summary>
            <income>nnnn</income>
            <rule rate="nnnn" status="s" range1="nnnn" range2="nnnnnn"/>
            <taxPaid>nnnn</taxPaid>
        </summary>
    </answer>
:)

<answer question="19">
{   
     let $file :=  fn:environment-variable("CITY_PROPERTIES")
    
    let $sum := fn:sum(for $x in doc($file)//property 
        where $x/@group = 1
        return data($x))
    for $n in doc($file)//rule
    where $n/@status eq "mfj" and $n/@range1 <= $sum and $n/@range2 >= $sum
      
    return <summary>  
    <income>{$sum}</income>   
          {$n}
          <taxPaid>{$sum*$n/@rate}</taxPaid>
    </summary>
    }
</answer>