# Write your MySQL query statement below
select
sample_id,
dna_sequence,
species,
dna_sequence LIKE 'ATG%' AS has_start,
dna_sequence REGEXP 'TAA$|TAG$|TGA$' AS has_stop,
dna_sequence LIKE '%ATAT%' AS has_atat,
dna_sequence REGEXP 'GGG+' AS has_ggg
from samples
order by sample_id;