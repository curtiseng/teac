SELECT telephone AS username,password,enabled FROM teac_user WHERE telephone=?;

SELECT
  user.telephone AS username, ga.authority AS authority
FROM
  teac_user user, group_authorities ga
WHERE
  user.telephone = ? AND user.group_id = ga.group_id;

SELECT
  g.id, g.group_name, ga.authority
FROM
  groups g, teac_user user, group_authorities ga
WHERE
  user.telephone = ? AND g.id = ga.group_id AND g.id = user.group_id;