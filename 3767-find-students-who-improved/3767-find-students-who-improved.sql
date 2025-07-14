# Write your MySQL query statement below
-- Finding the first exam date for each subject by each student 
with first_exam as (
    select * from scores
    where (student_id, subject, exam_date) in (
        select student_id, subject, min(exam_date) as first_score from scores
        group by student_id, subject
    )
),
-- Finding the last exam date for each subject by each student
latest_exam as (
    select * from scores
    where (student_id, subject, exam_date) in (
        select student_id, subject, max(exam_date) as first_score from scores
        group by student_id, subject
    )
),
-- Finding total attempts for each subject by any student
multiple_attempts as (
    select student_id, subject, count(distinct exam_date) from scores    
    group by student_id, subject
    having count(distinct exam_date) > 1
)
-- Meging the queries
select f.student_id, f.subject, f.score as first_score, l.score as latest_score from first_exam f
join latest_exam l
on f.student_id = l.student_id
and f.subject = l.subject
and f.score < l.score
where f.student_id in (
    select distinct student_id from multiple_attempts
)
order by 1,2