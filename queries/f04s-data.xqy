(: 
   https://riptutorial.com/xquery/example/16394/sum-over-values

   The Objective is to get the sum of all values

:)

<answer question="4s">
{
     let $file :=  "/data/sample.xml"  

     let $maxData := fn:max(for $x in doc($file)//value 
        return data($x))

     let $minData := fn:min(for $x in doc($file)//value 
        return data($x))

     let $sumData := fn:sum(for $x in doc($file)//value 
        return data($x))

     let $avgData := fn:avg(for $x in doc($file)//value 
        return data($x))

     return <summary>
               <max>{$maxData}</max>
               <min>{$minData}</min>
               <min>{$avgData}</min>
               <sum>{$sumData}</sum>
           </summary>
}
</answer>
