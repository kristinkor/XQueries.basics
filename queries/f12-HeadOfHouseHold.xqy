(: 
   https://riptutorial.com/xquery/example/16394/sum-over-values

   1) Display all the taxrates for head of house hold code = "hh"

:)

<answer question="12">
{
    let $file :=  fn:environment-variable("CITY_PROPERTIES")
        for $x in doc($file)//rule
        where $x/@status eq "hh" 
    return <taxrates>{data($x/@rate)}</taxrates>
}
</answer>
