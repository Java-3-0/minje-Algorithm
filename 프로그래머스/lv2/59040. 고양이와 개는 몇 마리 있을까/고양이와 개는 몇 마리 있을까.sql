-- 코드를 입력하세요
# SELECT ANIMAL_TYPE, count(*) as count from animal_ins group by animal_type

select ANIMAL_TYPE, count(*) from animal_ins where animal_type = 'Cat' union
select ANIMAL_TYPE, count(*) from animal_ins where animal_type = 'Dog';