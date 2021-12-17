(: 
   https://riptutorial.com/xquery/example/16394/sum-over-values

   1) The Objective is to get the sum of all values (net income) 
   where the group = "10". The net income is located
   between the property tags  

   output

        <answer question="16">
            <sum group="10">nnnn</sum>
        </answer>
:)

<answer question="16">
{     
    let $file :=  fn:environment-variable("CITY_PROPERTIES")
    
    let $sum := fn:sum(for $x in doc($file)//property 
        where $x/@group = 10
        return data($x))
    (: place your answer between the sum tag OR in the place where $sum is located :)      
    return <sum group= "10">     
          {$sum}
    </sum>
}
</answer>
