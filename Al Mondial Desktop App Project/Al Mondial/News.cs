using MySqlX.XDevAPI.Relational;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Al_Mondial
{
    public partial class News : Form
    {
        public News()
        {
            InitializeComponent();
            Controller c = new Controller();
            DataTable source = c.SelectAllMatches_ids();

            //foreach (DataRow row in dt.Rows)
            //{
            //    string st = row["C_Name"].ToString(); gets all the values from column C_Name in table dt
            //    comboBox1.Items.Add(st);
            //}
            foreach(DataRow row in source.Rows)
            {
                string st = row["Match_id"].ToString();
                comboBox2.Items.Add(st);
            }
            DataTable dt=c.SelectAllTeams();
            foreach (DataRow row in dt.Rows)
            {
                string st = row["id"].ToString();
                comboBox1.Items.Add(st);
            }
            comboBox1.DropDownStyle = ComboBoxStyle.DropDownList;
            comboBox1.Refresh();

            comboBox2.DropDownStyle = ComboBoxStyle.DropDownList;
            comboBox2.Refresh();

            comboBox2.SelectedIndex = 0;
            comboBox1.SelectedIndex = 0;

        }

        private void News_Load(object sender, EventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            Controller c = new Controller();
            string url = textBox1.Text.ToString();
            string title = textBox2.Text.ToString();
            bool favf = checkBox1.Checked;
            bool favm = !favf;
            int f_team=int.Parse(comboBox1.Text.ToString());
            int m_team = int.Parse(comboBox2.Text.ToString());
            int check = c.IsnertNews(url, title, favf, f_team, favm, m_team);
            if(check!=0)
            {
                MessageBox.Show("success");
            }
            else
            {
                MessageBox.Show("failed");
            }

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
        }

        private void comboBox2_SelectedIndexChanged(object sender, EventArgs e)
        {
       
        }

        private void comboBox1_SelectedIndexChanged_1(object sender, EventArgs e)
        {

        }
    }
}
