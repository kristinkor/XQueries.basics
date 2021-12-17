(: 
   https://riptutorial.com/xquery/example/16394/sum-over-values

   1) Display all the taxrates for a married filing jointly code = "mfj"

:)

<answer question="11">
{
    let $file :=  fn:environment-variable("CITY_PROPERTIES")
        for $x in doc($file)//rule
        where $x/@status eq "mfj" 
    return <taxrates>{data($x/@rate)}</taxrates>
}
</answer>
