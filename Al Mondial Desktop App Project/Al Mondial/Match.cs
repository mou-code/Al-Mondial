using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Al_Mondial
{
    public partial class Match : Form
    {
        Controller controller;
        public Match()
        {
            InitializeComponent();
            controller = new Controller();
            DataTable dt = controller.SelectAllTeams();
            DataTable dttemp = controller.SelectAllTeams();
            comboBox1.DataSource = dt;
            comboBox2.DataSource = dttemp;
            comboBox1.DisplayMember = "Name";
            comboBox1.ValueMember = "id";
            comboBox2.DisplayMember = "Name";
            comboBox2.ValueMember = "id";
            comboBox1.Refresh();
            comboBox2.Refresh();
            DataTable dt1 = controller.SelectAllRefrees();
            comboBox3.DataSource = dt1;
            comboBox3.DisplayMember = "Name";
            comboBox3.ValueMember = "Refree_id";
            comboBox3.Refresh();
            DataTable dt2 = controller.SelectAllStaduims();
            comboBox4.DataSource = dt2;
            comboBox4.DisplayMember = "Stadium_Name";
            comboBox4.ValueMember= "Stadium_Name";
            comboBox4.Refresh();
            DataTable dt3 = controller.SelectAllTeams();
            DataTable dt3temp = controller.SelectAllTeams();
            comboBox8.DataSource = dt3;
            comboBox7.DataSource = dt3temp;
            comboBox8.DisplayMember = "Name";
            comboBox8.ValueMember = "id";
            comboBox7.DisplayMember = "Name";
            comboBox7.ValueMember = "id";
            comboBox8.Refresh();
            comboBox7.Refresh();
            DataTable dt11 = controller.SelectAllRefrees();
            comboBox6.DataSource = dt11;
            comboBox6.DisplayMember = "Name";
            comboBox6.ValueMember = "Refree_id";
            comboBox6.Refresh();
            DataTable dt21 = controller.SelectAllStaduims();
            comboBox5.DataSource = dt21;
            comboBox5.DisplayMember = "Stadium_Name";
            comboBox5.ValueMember = "Stadium_Name";
            comboBox5.Refresh();
            textBox3.Enabled = false;
            comboBox9.Enabled = false;
        




        }

        private void button1_Click(object sender, EventArgs e)
        {
            int team1 = Int32.Parse(comboBox1.SelectedValue.ToString());
            int team2 = Int32.Parse(comboBox2.SelectedValue.ToString());
            if(team1 == team2)
            {
                MessageBox.Show("CouldNotAdd A Match Between The Same Team");
                return;
            }
            if(textBox1.Text.Length==0)
            {
                MessageBox.Show("Enter A Date");
                return;
            }
            string time=textBox1.Text;
           if(textBox2.Text.Length==0)
            {
                MessageBox.Show("Enter An Id");
                return;
            }
            int match_id = 0;
            try
            {
                match_id = Int32.Parse(textBox2.Text.ToString());
            }
            catch
            {
                MessageBox.Show("Error In Match_id ");
                return ;
            }
            int ref_id = Int32.Parse(comboBox3.SelectedValue.ToString());
            string stad_name=comboBox4.SelectedValue.ToString();
            int hour = (int)numericUpDown1.Value;
            if(hour>24||hour==0)
            {
                MessageBox.Show("InvalidHour");
                return;
            }
            
            int res = controller.InsertMatch(match_id, time, hour, team1, team2,"0",1, stad_name, ref_id);
            if (res == 0)
                MessageBox.Show("ErrorOccured");
            else
                MessageBox.Show("Inserted Successfully");
        }

        private void button2_Click(object sender, EventArgs e)
        {
            textBox3.Enabled = true;
            comboBox9.Enabled = true;
            DataTable dt = new DataTable();
            dt.Clear();
            dt.Columns.Add("Name");
            dt.Columns.Add("id");
            DataRow row1=dt.NewRow();
            DataRow row2=dt.NewRow();
            row1["Name"] = comboBox8.Text;
            row1["id"] = Int32.Parse(comboBox8.SelectedValue.ToString());
            row2["id"] = Int32.Parse(comboBox7.SelectedValue.ToString());
            row2["Name"] = comboBox7.Text;
            dt.Rows.Add(row1);
            dt.Rows.Add(row2);
            comboBox9.DataSource = dt;
                        comboBox9.DisplayMember="Name";
            comboBox9.ValueMember = "id";
            comboBox9.Refresh();

        }

        private void comboBox9_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {

            DataTable dt = controller.SelectMatch(Int32.Parse(comboBox8.SelectedValue.ToString()), Int32.Parse(comboBox7.SelectedValue.ToString()), comboBox5.SelectedValue.ToString(), Int32.Parse(comboBox6.SelectedValue.ToString()));
            int match_id = (int)dt.Rows[0][0];
            string score = textBox3.Text;
            int res = controller.UpdatematchScore(match_id, score);
            if (res == 0)
                MessageBox.Show("Error Occured");
            else
                MessageBox.Show("UpdatedSuccessfully");
        }

        private void label13_Click(object sender, EventArgs e)
        {

        }

        private void button4_Click(object sender, EventArgs e)
        {
            DataTable dt = controller.SelectMatch(Int32.Parse(comboBox8.SelectedValue.ToString()), Int32.Parse(comboBox7.SelectedValue.ToString()), comboBox5.SelectedValue.ToString(), Int32.Parse(comboBox6.SelectedValue.ToString()));
            int match_id = (int)dt.Rows[0][0];
            int Winner_id = Int32.Parse(comboBox9.SelectedValue.ToString());
            int res = controller.UpdatematchWinner(match_id, Winner_id);
            if (res == 0)
                MessageBox.Show("Error Occured");
            else
                MessageBox.Show("UpdatedSuccessfully");
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void button5_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
