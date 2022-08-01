-- 코드를 입력하세요
select animal_id, name from (SELECT a.animal_id, a.datetime as inTime, b.datetime as outTime, a.name from animal_ins a join animal_outs b where a.animal_id = b.animal_id order by inTime) as c where c.inTime > c.outTime

