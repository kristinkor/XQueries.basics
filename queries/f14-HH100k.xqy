(: 
   https://riptutorial.com/xquery/example/16394/sum-over-values

   1) Display all the taxrates for a Head of House Holde = "HH"
      and with a salary of 100,000 

    clue this should only return the 1 row a rate="0.24"  

	<answer question="14">
	   <rule rate="nn" status="nnn" range1="nnn" range2="nnnn"/>
	</answer>

:)

<answer question="14">
{
   let $file :=  fn:environment-variable("CITY_PROPERTIES")
      for $x in doc($file)//rule
      where $x/@status eq "hh" and $x/@range1 <= 100000 and $x/@range2 >= 100000
   return $x
}
</answer>
