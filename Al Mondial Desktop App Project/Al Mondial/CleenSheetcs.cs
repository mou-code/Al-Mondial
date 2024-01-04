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
    public partial class CleenSheetcs : Form
    {
        Controller controller;
        public CleenSheetcs()
        {
            InitializeComponent();
            controller = new Controller();  
            DataTable dt=controller.SelectAllMatches ();
            comboBox1.DataSource = dt;
            comboBox1.DisplayMember = "Match_id";
            DataTable dt2 = controller.SelectAllPlayers();
            comboBox2.DataSource = dt2;
            comboBox2.DisplayMember = "Name";
            comboBox2.ValueMember = "Player_id";
            comboBox1.Refresh();
            comboBox2.Refresh();


        }

        private void button11_Click(object sender, EventArgs e)
        {
           


            int res = controller.InsertCleenSheets(Int32.Parse(comboBox2.SelectedValue.ToString()), Int32.Parse(comboBox1.Text.ToString()));
            if (res == 0)
                MessageBox.Show("Error Occured");
            else
                MessageBox.Show("Added Successfully");


        }
    }
}
