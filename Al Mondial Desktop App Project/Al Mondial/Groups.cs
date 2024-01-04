using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace Al_Mondial
{
    public partial class Groups : Form
    {
        Controller controler;

        public Groups()
        {
            // comboBox1.Items.Clear();

           

            InitializeComponent();
            controler = new Controller();
            DataTable dt = controler.SelectAllTeams();
            comboBox2.DataSource = dt;
            comboBox2.DisplayMember = "Name";
            comboBox2.ValueMember = "id";
            comboBox2.Refresh();
            DataTable dt2 = controler.SelectAllGroups();
            comboBox1.DataSource = dt2;
            comboBox1.DisplayMember = "Group_id";
            comboBox1.Refresh();


        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click_1(object sender, EventArgs e)
        {

        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            Controller c = new Controller();
            if (c.InsertTeamIntoGroup(int.Parse(comboBox1.Text.ToString()), int.Parse(comboBox2.SelectedValue.ToString())) != 0)
            {
                MessageBox.Show("successfully");
            }
            else
            {
                MessageBox.Show("Failed");
            }
        }

        private void comboBox2_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void Groups_Load(object sender, EventArgs e)
        {

        }

     /*   private void button2_Click(object sender, EventArgs e)
        {
            Controller c = new Controller();
            int g_id = int.Parse(comboBox1.Text.ToString());
            int t_id = int.Parse(comboBox2.Text.ToString());
            int points = int.Parse(textBox1.Text.ToString());
            int games = int.Parse(textBox2.Text.ToString());
            int gf = int.Parse(textBox3.Text.ToString());
            int ga = int.Parse(textBox4.Text.ToString());
            int wins = int.Parse(textBox7.Text.ToString());
            int losses = int.Parse(textBox6.Text.ToString());
            int draw = int.Parse(textBox5.Text.ToString());
            if (c.updateTeamInGroup(g_id, t_id, points, games, gf, ga, wins, losses, draw) != 0)
            {
                MessageBox.Show("successfuly");
            }
            else
            {
                MessageBox.Show("Failed");
            }

        }
     */
        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox4_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox7_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox6_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox5_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox7_TextChanged_1(object sender, EventArgs e)
        {

        }

        private void comboBox1_SelectedIndexChanged_1(object sender, EventArgs e)
        {

        }

        private void button2_Click_1(object sender, EventArgs e)
        {
            Controller c = new Controller();
            int g_id = 0, t_id = 0, points = 0, games = 0, gf = 0, ga = 0, wins = 0, losses = 0, draw = 0;

            try
            {

                g_id = int.Parse(comboBox1.Text.ToString());
                t_id = int.Parse(comboBox2.SelectedValue.ToString());
                points = int.Parse(textBox1.Text.ToString());
                games = int.Parse(textBox2.Text.ToString());
                gf = int.Parse(textBox3.Text.ToString());
                ga = int.Parse(textBox4.Text.ToString());
                wins = int.Parse(textBox7.Text.ToString());
                losses = int.Parse(textBox6.Text.ToString());
                draw = int.Parse(textBox5.Text.ToString());
            }
            catch
            {
                MessageBox.Show("Error in your input data");
                return;
            }
            if (points > 9 || points < 0)
            {
                MessageBox.Show("invalid data for points");
                return;
            }
            if (wins > 3 || wins < 0)
            {
                MessageBox.Show("invalid data for wins");
                return;
            }
            if (losses > 3 || losses < 0)
            {
                MessageBox.Show("invalid data for losses");
                return;
            }
            if ((draw + wins + losses) > 3)
            {
                MessageBox.Show("invalid data the sum of total games");
                return;
            }
            if (draw > 3 || draw < 0)
            {
                MessageBox.Show("invalid data for draw");
                return;
            }
            if (games > 3 || games < 0)
            {
                MessageBox.Show("invalid data for games");
                return;
            }

            if (c.updateTeamInGroup(g_id, t_id, points, games, gf, ga, wins, losses, draw) != 0)
            {
                MessageBox.Show("successfuly");
            }
            else
            {
                MessageBox.Show("Failed");
            }
            if (c.updateTeamInGroup(g_id, t_id, points, games, gf, ga, wins, losses, draw) != 0)
            {
                MessageBox.Show("successfuly");
            }
            else
            {
                MessageBox.Show("Failed");
            }
        }
    }
}
