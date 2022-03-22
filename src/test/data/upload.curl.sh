#! /bin/bash
data_dir="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"


echo ""
echo "posting booktitles to $1"

let time_start=$(date +%s)
for i in {1..10000}
do
	let fat_i=$i
	curl -H "Content-Type:application/json" -q -d "{\"id\":\"${i}\",\"name\":\"Sams Teach Yourself Java in ${i} Days\", \"author\": \"Rogers Cadenhead ${i}\"}" http://localhost:$1/booktitles &
done
let time_finish=$(date +%s)
let time_taken=time_finish-time_start

echo "===================================="
echo "summary for posting booktitles to $1"
echo "start: $time_start"
echo "finish: $time_finish"
echo "time taken: $time_taken"
echo "===================================="
echo ""