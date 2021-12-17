(: 
   https://riptutorial.com/xquery/example/16394/sum-over-values

   1) Display all the taxrates for code = "mfj"
      and with a salary of 400,000 

    clue this should only return the 1 row

	<answer question="14">
	   <rule rate="nn" status="nnn" range1="nnn" range2="nnnn"/>
	</answer>


:)

<answer question="15">
{
   let $file :=  fn:environment-variable("CITY_PROPERTIES")
      for $x in doc($file)//rule
      where $x/@status eq "mfj" and $x/@range1 <= 400000 and $x/@range2 >= 400000
   return $x
}
</answer>
