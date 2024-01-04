using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;
//using System.Windows.Forms;
namespace Al_Mondial
{
    public class Controller
    {
        DBManager dbMan;
        public Controller()
        {
            dbMan = new DBManager();
        }


        public void TerminateConnection()
        {
            dbMan.CloseConnection();
        }
        public int InsertPlayer(int id,string name, int gs, int cs, int age,string p,int Team_id)
        {
            string query = "INSERT INTO player Values('" + id + "','" + name + "','" + gs + "','" + cs + "','" + age + "','" + p + "','"+Team_id+"');";
            return dbMan.ExecuteNonQuery(query);
        }
        public DataTable SelectAllPlayers()
        {
            string query = "SELECT Player_id,Name FROM player;";
            return dbMan.ExecuteReader(query);
        }
        public DataTable SelectAllTeams()
        {
            string query = "SELECT id,Name FROM team;";
            return dbMan.ExecuteReader(query);
        }
        public DataTable SelectMatch(int t1,int t2,string stad_name,int ref_id)
        {
            string query = "SELECT Match_id FROM `match` WHERE Team1_id='"+t1+"' AND Team2_id='"+t2+"' AND Stadium_Name='"+stad_name+ "' AND refree_id='"+ref_id+"';";
            return dbMan.ExecuteReader(query);
        }
        public DataTable SelectAllRefrees()
        {
            string query = "SELECT Refree_id,Name FROM refree;";
            return dbMan.ExecuteReader(query);
        }
        public DataTable SelectAllMatches()
        {
            string query = "SELECT Match_id FROM `match`;";
            return dbMan.ExecuteReader(query);
        }
        public DataTable SelectAllStaduims()
        {
            string query = "SELECT Stadium_Name FROM stadium;";
            return dbMan.ExecuteReader(query);
        }
        public DataTable SelectAllTickets()
        {
            string query = "SELECT Ticket_id FROM ticket;";
            return dbMan.ExecuteReader(query);
        }
        public DataTable SelectAllUsers()
        {
            string query = "SELECT Username,Name FROM user;";
            return dbMan.ExecuteReader(query);
        }
        public DataTable SelectUsernamespass()
        {
            string query = "SELECT Username,Pass FROM user;";
            return dbMan.ExecuteReader(query);
        }
        public DataTable SelectPlayerGoals(int id)
        {
            string query = "SELECT GoalsScored FROM player WHERE Player_id='"+id+"';";
            return dbMan.ExecuteReader(query);
        }
        public int UpdatePlayerGoals(int id,int gs)
        {
            string query = "UPDATE player SET GoalsScored='"+gs+"'WHERE Player_id='"+id+"';";
            return dbMan.ExecuteNonQuery(query);
        }
        public DataTable SelectPlayerCleanSheets(int id)
        {
            string query = "SELECT CleanSheets FROM player WHERE Player_id='" + id + "';";
            return dbMan.ExecuteReader(query);
        }
        public int UpdatePlayerCleanSheets(int id, int cs)
        {
            string query = "UPDATE player SET CleanSheets='" + cs + "'WHERE Player_id='" + id + "';";
            return dbMan.ExecuteNonQuery(query);
        }
        public int InsertGoal(int P_id, int T_id,int Min )
        {
            string query = "INSERT INTO goal Values('" + P_id + "','" + T_id + "','" + Min + "');";
            return dbMan.ExecuteNonQuery(query);
        }
        public int InsertCleenSheets(int P_id, int M_id)
        {
            string query = "INSERT INTO cleensheet Values('" + P_id + "','" + M_id + "');";
            return dbMan.ExecuteNonQuery(query);
        }
        public int InsertStaduim(string S_Name, int c, string  L)
        {
            string query = "INSERT INTO stadium Values('" + S_Name + "','" + c + "','" + L + "');";
            return dbMan.ExecuteNonQuery(query);
        }
        public int InsertRefree( int id, string R_Name)
        {
            string query = "INSERT INTO refree Values('" +id + "','" + R_Name + "');";
            return dbMan.ExecuteNonQuery(query);
        }
        public int InsertCoach(int id, string Name,int a,string nation)
        {
            string query = "INSERT INTO coach Values('" + id + "','" + Name + "','" + a + "','" + nation + "');";
            return dbMan.ExecuteNonQuery(query);
        }
        public int InsertMatch(int id,string time,int h,int t1,int t2,string score,int a, string Stad_name, int ref_id)
        {
            string query = "INSERT INTO `match` Values('" + id + "','" + time + "','" + h + "','" + t1 + "','" + t2 + "','"+"0"+"','"+1+"','" + Stad_name + "','" + ref_id + "');";
            return dbMan.ExecuteNonQuery(query);
        }

        public int UpdatematchScore(int match_id,string score)
        {
            string query = "UPDATE `match` SET Score='"+score+"' WHERE Match_id='"+match_id+"';";
            return dbMan.ExecuteNonQuery(query);
        }
        public int UpdatematchWinner(int match_id, int Wineer)
        {
            string query = "UPDATE `match` SET Winner='" + Wineer + "' WHERE Match_id='" + match_id + "';";
            return dbMan.ExecuteNonQuery(query);
        }
        public int AddTicket(int t_id,int c,int match_id)
        {
            string query = "INSERT INTO ticket Values('" + t_id + "','" + c + "','"+match_id+"');";
            return dbMan.ExecuteNonQuery(query);
        }
        public int AssignTicket(int t_id,string un)
        {
            string query = "INSERT INTO ticket_user Values('" + t_id + "','" + un + "');";
            return dbMan.ExecuteNonQuery(query);
        }
        public int DropTicket(int t_id)
        {
            string query = "DELETE FROM ticket WHERE Ticket_id='"+t_id+"';";
            return dbMan.ExecuteNonQuery(query);
        }
        public int InsertTeam(int id, string Name,int g_id,string spon_name)
        {
            string query = "INSERT INTO `team` Values('" + id + "','" + Name + "','" + g_id + "','" + spon_name + "');";
            return dbMan.ExecuteNonQuery(query);
        }
        public DataTable SelectAllGroups()
        {
            string query = "SELECT Group_id FROM groupnum;";
            return dbMan.ExecuteReader(query);
        }
        public DataTable SelectAllSponsers()
        {
            string query = "SELECT Sponser_Name FROM sponser;";
            return dbMan.ExecuteReader(query);
        }
        public DataTable SelectUserType(string un)
        {
            string query = "SELECT Type FROM user WHERE username='"+un+"';";
            return dbMan.ExecuteReader(query);
        }
        public int MakeAdmin(string user)
        {
            string query = "UPDATE user SET Type='"+0+"' WHERE Username= '" + user + "' ;";
            return dbMan.ExecuteNonQuery(query);
        }
        public int Insertsponser(string name)
        {
            string query = "INSERT INTO sponser VALUES('" + name + "');";
            return dbMan.ExecuteNonQuery(query);
        }
        public int Deletesponser(string name)
        {
            string query = "DELETE FROM sponser WHERE Sponser_Name='" + name + "';";
            return dbMan.ExecuteNonQuery(query);
        }
        public int updateTeamInGroup(int g_id, int t_id, int points, int games, int gf, int ga, int win, int loss, int draw)
        {
            int gd = gf - ga;

            string query = "UPDATE groupstate SET Points='" + points + "' , Games='" + games + "' , GoalsFor='" + gf + "' , GoalsAgainst='" + ga + "', GoalsDiff='" + gd + "', Wins='" + win + "',Losses='" + loss + "' ,Draws='" + draw + "' WHERE Team_id='" + t_id + "' ;";
            return dbMan.ExecuteNonQuery(query);
        }
        public int IsnertNews(string url, string title, bool f_flag, int fav_id, bool mflag, int m_id)
        {
            string query = "INSERT INTO news VALUES('" + url + "','" + title + "','" + f_flag + "','" + fav_id + "','" + mflag + "','" + m_id + "');";
            return dbMan.ExecuteNonQuery(query);
        }
        public int InsertTeamIntoGroup(int g_id,int t_id)
        {
            string query = "INSERT INTO GroupState Values(" + g_id + "," + t_id + "," + 0 + "," + 0 + "," + 0 + "," + 0 + "," + 0 + "," + 0 + "," + 0 + "," + 0 + ");";
            return dbMan.ExecuteNonQuery(query);
        }
        public DataTable SelectAllMatches_ids()
        {
            string query = "SELECT Match_id FROM `match`;";
            return dbMan.ExecuteReader(query);
        }
        public DataTable SelectUserWallet(string user_n)
        {
            string query = "SELECT Wallet FROM user WHERE Username='"+user_n+"';";
            return dbMan.ExecuteReader(query);
        }
        public DataTable SelectTicketCost(int t_id)
        {
            string query = "SELECT cost FROM ticket WHERE Ticket_id='" + t_id + "';";
            return dbMan.ExecuteReader(query);
        }
        public DataTable GetCapacity(int t_id)
        {
            string query = "SELECT capacity FROM ticket,`match`,stadium WHERE Ticket_id='"+t_id+"' AND ticket.Match_id=match.Match_id AND match.Stadium_Name=stadium.Stadium_Name;";
            return dbMan.ExecuteReader(query);
        }
        public DataTable GetTicketsCount(int t_id)
        {
            string query = "SELECT * FROM `ticket_user` WHERE Ticket_id='"+t_id+"';";
            return dbMan.ExecuteReader(query);
        }
    }
}
