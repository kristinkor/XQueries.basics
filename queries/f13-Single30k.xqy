(: 
   https://riptutorial.com/xquery/example/16394/sum-over-values

   1) Display all the taxrates for a single code = "s"
      and with a salary of 30,000 

    clue this should only return the 1 row a rate="0.12"

	Sample Output
 
        <answer question="13">
	   <rule rate="nn" status="nnn" range1="nnn" range2="nnnn"/>
	</answer>


:)

<answer question="13">
{
    let $file :=  fn:environment-variable("CITY_PROPERTIES")
        for $x in doc($file)//rule
        where $x/@status eq "s" and $x/@range1 < 30000 and $x/@range2 > 30000
    return $x
}
</answer>
