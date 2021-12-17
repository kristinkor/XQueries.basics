(: 
   https://riptutorial.com/xquery/example/16394/sum-over-values

   1) Display all the taxrates for a single code = "s"
      

:)

<answer question="10">
{
    let $file :=  fn:environment-variable("CITY_PROPERTIES")
        for $x in doc($file)//rule
        where $x/@status eq "s" 
    return <taxrates>{data($x/@rate)}</taxrates>
}
</answer>
